package iie.grpctool;

import com.google.protobuf.ByteString;
import iie.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private String engineName;
    private String engineVersion;
    private int port;
    private String host;
    private String addr;
    private final VectorGrpc.VectorBlockingStub blockingStub;
    private final ManagedChannel channel;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public GrpcClient(String addr) {
        this.addr= addr;
        this.port = Integer.parseInt(addr.split(":")[1]);
        this.host = addr.split(":")[0];
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public GrpcClient(String host, int port) {
        this.addr= host + ":" + port;
        this.port = port;
        this.host = host;
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public GrpcClient(String host, int port, String name, String version) {
        this.engineName = name;
        this.engineVersion = version;
        this.addr= host + ":" + port;
        this.port = port;
        this.host = host;
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public GrpcClient(String address, String name, String version) {
        this.addr = address;
        this.engineName = name;
        this.engineVersion = version;
        this.port = Integer.parseInt(address.split(":")[1]);
        this.host = address.split(":")[0];
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
    }

//    public VectorResponse search(Map<String, String> map) {
//        VectorRequest vectorRequest = VectorRequest.newBuilder().putAllBatchQuery(map).build();
//        return blockingStub.search(vectorRequest);
//    }


    /**
     * 实体识别接口
     * @param url
     * @return
     */
    public LocateEntries getObjectsByUrl(String url){
        return blockingStub.getObjectsByUrl(ImageUrl.newBuilder().setUrl(url).build());
    }

    /**
     * 实体识别接口
     * @param image
     * @return
     */
    public LocateEntries getObjectsByBytes(byte[] image){
        return blockingStub.getObjectsByBytes(ImageBytes.newBuilder().setImage(ByteString.copyFrom(image)).build());
    }

    /**
     * 实体识别接口
     * @param image
     * @return
     */
    public LocateEntries getObjectsByBytes(ByteString image){
        return blockingStub.getObjectsByBytes(ImageBytes.newBuilder().setImage(image).build());
    }



    /**
     * 批量查询接口
     * @param map
     * @return
     */
    public Map<String, List<ByteString>> search(Map<String, String> map) {
        Map<String, List<ByteString>> result = new HashMap<>();
        VectorRequest vectorRequest = VectorRequest.newBuilder().putAllBatchQuery(map).build();
        VectorResponse tasks = blockingStub.search(vectorRequest);
        tasks.getBatchVectorMap().forEach((k, v) -> {
            if (!v.getCode().equals("-1")){
                List<ByteString> list = new ArrayList<>();
                list.addAll(v.getImageVectorsMap().values());
                result.put(k, list);
            }else {
                System.out.println("taks '" + k + "' request failed with code :" + v.getCode() + ", info : " + v.getFailed());
            }
        });
        return result;
    }

    /**
     * 批量查询接口
     * @param vectorRequest
     * @return
     */
    public VectorResponse search(VectorRequest vectorRequest) {
        return blockingStub.search(vectorRequest);
    }

    /**
     * 查询vector接口
     * @param url
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public BytesResponse searchByUrl(String url, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return blockingStub.searchByUrl(
                UrlRequest.newBuilder()
                        .setImageUrl(url)
                        .setX1(x1)
                        .setY1(y1)
                        .setX2(x2)
                        .setY2(y2)
                        .setX3(x3)
                        .setY3(y3)
                        .setX4(x4)
                        .setY4(y4)
                        .build());
    }

    /**
     * 查询vector接口
     * @param urlRequest
     * @return
     */
    public BytesResponse searchByUrl(UrlRequest urlRequest) {
        return blockingStub.searchByUrl(urlRequest);
    }

    /**
     * 查询vector接口
     * @param image
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public BytesResponse searchByBytes(byte[] image,int x1, int y1, int x2, int y2,
                                       int x3, int y3, int x4 , int y4) {
        return blockingStub.searchByBytes(BytesRequest.newBuilder()
                .setImageBytes(ByteString.copyFrom(image))
                .setX1(x1)
                .setY1(y1)
                .setX2(x2)
                .setY2(y2)
                .setX3(x3)
                .setY3(y3)
                .setX4(x4)
                .setY4(y4)
                .build());
    }

    /**
     * 查询vector接口
     * @param image
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public BytesResponse searchByBytes(ByteString image,int x1, int y1, int x2, int y2,
    int x3, int y3, int x4 , int y4) {
        return blockingStub.searchByBytes(BytesRequest.newBuilder()
                .setImageBytes(image)
                .setX1(x1)
                .setY1(y1)
                .setX2(x2)
                .setY2(y2)
                .setX3(x3)
                .setY3(y3)
                .setX4(x4)
                .setY4(y4)
                .build());
    }

    /**
     * 查询vector接口
     * @param bytesRequest
     * @return
     */
    public BytesResponse searchByBytes(BytesRequest bytesRequest) {
        return blockingStub.searchByBytes(bytesRequest);
    }


    /**
     * 对外接口
     * @param queryByUrlEntry
     * @return
     */
    public ResultEntryHash getVectorByUrl(QueryByUrlEntry queryByUrlEntry){
        return blockingStub.getVectorByUrl(queryByUrlEntry);
    }
    public ResultEntryHash getVectorByUrl(String space, long start, long end, String url){
        QueryByUrlEntry queryByUrlEntry = QueryByUrlEntry.newBuilder()
                .setSpace(space)
                .setStartTime(0)
                .setEndTime(15055555555l)
                .setImage(
                        UrlRequest.newBuilder()
                                .setImageUrl("http://10.136.75.20:20099/get?" +
                                "key=itest10010@be0b5fd9aa53bd7bf8255cf2dd6fa28a")
                                .setX1(166)
                                .setY1(63)
                                .setX2(212)
                                .setY2(63)
                                .setX3(212)
                                .setY3(129)
                                .setX4(166)
                                .setY4(129)
                                .build())
                .build();
        return blockingStub.getVectorByUrl(queryByUrlEntry);
    }
}
