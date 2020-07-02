package iie.grpctool;

import com.google.protobuf.ByteString;
import iie.configs.Config;
import iie.grpc.BytesResponse;
import iie.grpc.ResultEntry;
import iie.grpc.ResultEntryHash;
import iie.tool.MemcachedTool;
import iie.tool.RedisPool;
import redis.clients.jedis.Jedis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VectorClient {
    private RedisPool redisPool;
    //<engine:version, grpc>
    private ConcurrentHashMap<String, GrpcClient> grpcClientHash = new ConcurrentHashMap<>();
    //<engine:version, size>
    private ConcurrentHashMap<String, String> vectorSizeHash = new ConcurrentHashMap<>();
    //<engine:version, startTime-endTime>>
    private ConcurrentHashMap<String, String> versionHash = new ConcurrentHashMap<>();

    private void initVersionAndGrpc(boolean init) {
        Jedis jedis = null;
        try{
            jedis = redisPool.getResource();
            //<engine:version, ip:port>
            Map<String, String> engineVersionHash = jedis.hgetAll("engine-http.version.conf");
            Map<String, String> engineAddrs = jedis.hgetAll("engine-http.addr.conf");
            Map<String, String> engineVectorSize = jedis.hgetAll("engine-http.vector.size");
            System.out.println("1......." + engineVersionHash.keySet().size() + ":" + engineAddrs.keySet().size() + ":" +
                    engineVectorSize.keySet().size());
            versionHash.putAll(engineVersionHash);
            vectorSizeHash.putAll(engineVectorSize);
            engineAddrs.forEach((k, v) -> {
                grpcClientHash.put(k, new GrpcClient(v, k.split(":")[0], k.split(":")[1]));
            } );
        }finally {
            if (jedis != null)
                jedis.close();
        }
    }
    private class RefreshTimerTask extends TimerTask {
        @Override
        public void run() {
            try {
                Jedis jedis = null;
                try{
                    jedis = redisPool.getResource();
                    //<engine:version, ip:port>
                    Map<String, String> engineVersionHash = jedis.hgetAll("engine-http.version.conf");
                    Map<String, String> engineAddrs = jedis.hgetAll("engine-http.addr.conf");
                    Map<String, String> engineVectorSize = jedis.hgetAll("engine-http.vector.size");
                    System.out.println("2......." + engineVersionHash.keySet().size() + ":" + engineAddrs.keySet().size() + ":" +
                            engineVectorSize.keySet().size());
                    versionHash.putAll(engineVersionHash);
                    vectorSizeHash.putAll(engineVectorSize);
                    engineAddrs.forEach((k, v) -> {
                        if (grpcClientHash.get(k) == null){
                            grpcClientHash.put(k, new GrpcClient(v, k.split(":")[0], k.split(":")[1]));
                        } else {
                            if ((grpcClientHash.get(k).getAddr()).equals(v)){

                            }else {
                                try {
                                    GrpcClient grpcClient = new GrpcClient(v, k.split(":")[0], k.split(":")[1]);
                                    grpcClientHash.get(k).shutdown();
                                    grpcClientHash.put(k, grpcClient);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } );


                }finally {
                    if (jedis != null)
                        jedis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[ERROR] refresh engine address and versions: "
                        + e.getMessage() + ".\n" + e.getCause());
            }
        }
    }
    public void init() throws Exception {
        redisPool = new RedisPool(Config.redisUrl, Config.redisMasterName);
        if (Config.isUseCache){
            MemcachedTool.init(Config.memcachedUrl.split(":")[0],
                    Integer.parseInt(Config.memcachedUrl.split(":")[1]));
        }
        Timer timer = new Timer();
        initVersionAndGrpc(true);
        timer.schedule(new RefreshTimerTask(), 30 * 1000, 30 * 1000);
    }

    /**
     *
     * @param engineName
     * @param startTime
     * @param endTime
     * @return engine:version
     */
    private Map<String, String> getEngineVersion(String engineName, long startTime, long endTime){
        Map<String, String> versions = new HashMap<>();
        versionHash.forEach((k, v) -> {
            if (k.contains(engineName)){
                String[] ss = v.split(":");
                long[] times = new long[2];
                times[0] = Long.parseLong(ss[0]);
                times[1] = ss.length == 2 ? Long.parseLong(ss[1]) : Instant.now().toEpochMilli();
                if (!(startTime > times[1] || endTime < times[0])){
                    List<Long> list = new ArrayList<>();
                    list.add(times[0]);
                    list.add(times[1]);
                    list.add(startTime);
                    list.add(endTime);
                    list.sort(Comparator.comparingLong(Long::longValue));
                    versions.put(k, list.get(1) + ":" + list.get(2));
                }
            }
        });
        return versions;
    }
    private Map<String, GrpcClient> getGrpcClient(String engineName, long startTime, long endTime){
        //face:v1.0 1560000000:1569999999
        Map<String, String> engineVersions = getEngineVersion(engineName, startTime, endTime);
        Map<String, GrpcClient> clients = new HashMap<>();
        engineVersions.forEach((k, v) -> {
            clients.put(v, grpcClientHash.get(k));
            System.out.println(" time  " + v + ", engien name " + grpcClientHash.get(k).getEngineName());
        });
        return clients;
    }

    /**
     * zzq转发界面请求
     * @param engineName
     * @param startTime
     * @param endTime
     * @param contents
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public ResultEntryHash getVectors(String engineName, long startTime, long endTime,
                                                    ByteString contents, int x1, int y1, int x2, int y2,
                                      int x3, int y3, int x4, int y4){
        ResultEntryHash.Builder builder = ResultEntryHash.newBuilder();
        Map<String, GrpcClient> clients = getGrpcClient(engineName, startTime, endTime);
        byte[] contentsBytes = contents.toByteArray();
        String md5 = null;
        if (Config.isUseCache)
            md5 = getMd5(contentsBytes);
        for( Map.Entry<String, GrpcClient> entry : clients.entrySet()){
            String k = entry.getKey();
            GrpcClient v = entry.getValue();
            String engineVersion = v.getEngineName() + ":" + v.getEngineVersion();
            ByteString vector = null;
            String key = engineVersion + "#" + md5 + "#" + x1 + "#" +y1 + "#" + x2 + "#" + y2
                    + "#" + x3 + "#" + y3+ "#" + x4 + "#" + y4;
            if (Config.isUseCache){
                byte[] bs  = getFromMemcached(key);
                if (bs != null)
                    vector = ByteString.copyFrom(bs);
            }
            if (vector == null){
                BytesResponse br = v.searchByBytes(contents, x1, y1, x2, y2, x3, y3, x4, y4);
                if (br.getCode().equals("0"))
                    vector = br.getVectorBytes();
            }
            if (Config.isUseCache && vector != null){
                MemcachedTool.set(key,
                        vector.toByteArray());
            }
            if (vector == null){
                System.out.println("get " + key + " null");
            }else {
                String[] times = k.split(":");
                builder.addResultEntries(ResultEntry.newBuilder()
                        .setSpace(engineName)
                        .setVersion(engineVersion)
                        .setStartTime(Long.parseLong(times[0]))
                        .setEndTime(Long.parseLong(times[1]))
                        .setVector(vector)
                        .build());
            }
        }
        return builder.build();
    }
    public ResultEntryHash getVectors(String engineName, long startTime, long endTime,
                                      String url, int x1, int y1, int x2, int y2,
                                      int x3, int y3, int x4, int y4){
        ResultEntryHash.Builder builder = ResultEntryHash.newBuilder();
        Map<String, GrpcClient> clients = getGrpcClient(engineName, startTime, endTime);
        for( Map.Entry<String, GrpcClient> entry : clients.entrySet()){
            String k = entry.getKey();
            GrpcClient v = entry.getValue();
            String engineVersion = v.getEngineName() + ":" + v.getEngineVersion();
            ByteString vector = null;
            String key = engineVersion + "#" + url + "#" + x1 + "#" +y1 + "#" + x2 + "#" + y2
                    + "#" + x3 + "#" + y3+ "#" + x4 + "#" + y4;
            if (Config.isUseCache){
                byte[] bs  = getFromMemcached(key);
                if (bs != null)
                    vector = ByteString.copyFrom(bs);
            }
            if (vector == null){
                long start = System.currentTimeMillis();
                System.out.println("send request to face : " + url +
                        ", " + x1 + ", " + y1 +
                        ", " + x2 + ", " + y2 +
                        ", " + x3 + ", " + y3 +
                        ", " + x4 + ", " + y4);
                BytesResponse br = v.searchByUrl(url, x1, y1, x2, y2, x3, y3, x4, y4);
//                System.out.println("gg to engine  time used "  + (System.currentTimeMillis() - start));
                if (br.getCode().equals("0")){
                    vector = br.getVectorBytes();
                    System.out.println(getTime() + " 引擎返回 ：url = " + url + ", vector size = " + vector.size());
                }
                else
                    System.out.println(getTime() + " 引擎返回： : url = " + url + " code is " + br.getCode());
            }
            if (Config.isUseCache && vector != null){
                MemcachedTool.set(key,
                        vector.toByteArray());
            }
            if (vector == null){
                System.out.println("get " + key + " null");
            }else {
                String[] times = k.split(":");
                builder.addResultEntries(ResultEntry.newBuilder()
                        .setSpace(engineName)
                        .setVersion(v.getEngineVersion())
                        .setStartTime(Long.parseLong(times[0]))
                        .setEndTime(Long.parseLong(times[1]))
                        .setVector(vector)
                        .build());
            }
        }
        return builder.build();
    }

    private byte[] getFromMemcached(String key){
        return MemcachedTool.get(key);
    }

    private String getMd5(byte[] bytes) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("md5");
            md.update(bytes);
            byte[] mdbytes = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < mdbytes.length; j++) {
                sb.append(Integer.toString((mdbytes[j] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private byte[] byteStringListToBytes(List<ByteString> bss, int size){
        byte[] result = null;
        List<byte[]> bsl = new ArrayList<byte[]>();
        if (bss.size() == 1){
            return bss.get(0).toByteArray();
        }
        for (ByteString bs : bss) {
            if (bs.size() == size)
                result = ArrayUtils.addAll(result, bs.toByteArray());
        }
        return result;
    }
    private List<ByteString> bytesToByteStringList(byte[] bs, int size){
        List<ByteString> byteStringsList = new ArrayList<>();
        if (bs.length/size == 1){
            byteStringsList.add(ByteString.copyFrom(bs));
            return byteStringsList;
        }
        for (int i = 0; i < bs.length/size; i++) {
           byteStringsList.add(ByteString.copyFrom(ArrayUtils.subarray(bs,
                   i * size, (i + 1) * size)));
        }
        return byteStringsList;
    }*/


    public void quit(){
        grpcClientHash.forEach((k, v) -> {
            try {
                v.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    private static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
}
