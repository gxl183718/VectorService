package iie.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import iie.configs.Config;
import iie.grpc.LocateEntries;
import iie.grpc.LocateEntry;
import iie.grpctool.GrpcClient;
import iie.httptool.HttpRequest;
import iie.httptool.OKClientUtils;
import iie.tool.Tag;
import iie.tool.TagsManager;
import iie.tool.TimeOutUtil;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.json.JavalinJson;
import mammoth.jclient.ClientAPI;
import org.apache.avro.data.Json;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class YoloHttpServer {
    private ClientAPI clientAPI;
    private TagsManager tagsManager;

    public ClientAPI getClientAPI() {
        return clientAPI;
    }

    public void setClientAPI(ClientAPI clientAPI) {
        this.clientAPI = clientAPI;
    }

    public TagsManager getTagsManager() {
        return tagsManager;
    }

    public void setTagsManager(TagsManager tagsManager) {
        this.tagsManager = tagsManager;
    }

    public YoloHttpServer(ClientAPI clientAPI) {
        this.clientAPI = clientAPI;
    }

    public void startHttpServer() {
        try {
            //查询标签的daemon线程
            tagsManager = new TagsManager();
            Thread thread = new Thread(tagsManager);
            thread.setName("tags-manager-thread");
            thread.setDaemon(true);
            thread.start();

            //初始化yolo和face引擎
            GrpcClient clientFace = new GrpcClient(Config.yoloFaceServerUrl, Config.yoloFaceServerPort, "face", "1.0");
            GrpcClient clientYolo = new GrpcClient(Config.yoloServerUrl, Config.yoloServerPort, "whole", "1.0");

            Javalin app =Javalin.create(config -> {
                config.addStaticFiles(Config.staticDir, Location.EXTERNAL)
                        .defaultContentType = "text/plain;charset=utf-8";
            });
            JavalinJson.setToJsonMapper(JSON::toJSONString);
            app.exception(Exception.class, (exception, ctx) -> {
                exception.printStackTrace();
                Map<String, Object> map = new HashMap<>();
                map.put("message", exception.getMessage());
                ctx.json(map);
            });
            //媒体向量查询
            app.post("/yoloQuery", ctx -> {
                long start = System.currentTimeMillis();
                String contentType = ctx.formParam("contentType");
                String content = ctx.formParam("content");
                Map<String, Object> result = new HashMap<>();
                System.out.println(getTime() + " post request : contentType='" + contentType
                + "', content='" + content + "'.");
                result.put("success", true);
                result.put("message", "解析成功");
                result.put("code", 200);
                iie.server.Locate locate = new iie.server.Locate();
                if ("text".equals(contentType)){
                    locate.setSimhash(getSimHas(content) + "");
                    locate.setText(content);
                    List<Map<String, String>> keyWords = getKeyWords(content);
                    locate.setKeyWords(keyWords);
                    result.put("data", locate);
                    ctx.json(result);
                }else if ("img".equals(contentType)){

                    String url = null;
                    String md5 = null;
                    if (content == null || !content.contains("key=")){
                        InputStream stream = ctx.uploadedFile("file").getContent();
                        byte[] contents = inputStream2byte(stream);
                        md5 = getMd5(contents);
                        //界面上传的图片临时存储的set
                        String key = Config.tmpUISet + "@" + md5;
                        clientAPI.put(key, contents);
                        url = Config.mamPre + key;
                        System.out.println(new Date() + " 用户上传图片 ‘" + ctx.uploadedFile("file").getFilename()
                        + "’, url=" + url);
                    }else {
                        url = content;
                        md5 = url.split("@")[1];
                        System.out.println(new Date() + " 系统内部图片 url=" + url);
                    }

                    //数据异步处理
                    long time0 = System.currentTimeMillis();
                    CompletableFuture<String> f1 = TimeOutUtil.asyncProcess(new HttpTask(url, "ocr"), 5);
                    CompletableFuture<LocateEntries> f2 = TimeOutUtil.asyncProcess(new GrpcTask(clientFace, url), 5);
                    CompletableFuture<LocateEntries> f3 = TimeOutUtil.asyncProcess(new GrpcTask(clientYolo, url), 5);
                    while(f1.isDone() == false || f2.isDone() == false || f3.isDone() == false){
                        Thread.sleep(10);
                    }

                    locate.setText(f1.get());
                    LocateEntries lesFace  = f2.get();
                    LocateEntries lesYolo = f3.get();
                    List<Map<String, String>> list;
                    if (f1.get() != null && !"".equals(f1.get())){
                        long t1 = System.currentTimeMillis();
                        list = getKeyWords(f1.get());
                        locate.setKeyWords(list);
                        long t2 = System.currentTimeMillis();
                        System.out.println("ocr 内容关键词解析耗时：" + (t2 - t1) + " ms.");
                    }
                    long time1 = System.currentTimeMillis();

                    System.out.println(getTime() + "解析总耗时" + (time1-time0) +  "ms.");

                    List<iie.server.Locate.Position> positions = new ArrayList<>();
                    List<iie.server.Locate.Tag> tags = new ArrayList<>();
                    List<Map<String, String>> keyWords = new ArrayList<>();
                    //face
                    if (lesFace == null){
                        System.out.println(getTime() + "face search timeout!");
                    }else if (lesFace.getCode().equals("0")){
                        locate.setImgWidth(lesFace.getW());
                        locate.setImgHeight(lesFace.getH());
                        int ln = 1;
                        for (LocateEntry locateEntry : lesFace.getLocatesList()) {
                            iie.server.Locate.Position position = new iie.server.Locate.Position();
                            List<Integer> pos = new ArrayList<>();
                            pos.add(0,locateEntry.getX1());
                            pos.add(1,locateEntry.getY1());
                            pos.add(2,locateEntry.getX2());
                            pos.add(3,locateEntry.getY2());
                            pos.add(4,locateEntry.getX3());
                            pos.add(5,locateEntry.getY3());
                            pos.add(6,locateEntry.getX4());
                            pos.add(7,locateEntry.getY4());
                            position.setScore(toFloat2(locateEntry.getSimilarity()));
                            position.setPos(pos);
                            position.setType(locateEntry.getType());
//                            String lb = Config.faceTags.get(locateEntry.getLabel());
//                            position.setLabel(lb == null ? "" : lb);
//                            System.out.println(new Date() + "....face label" + locateEntry.getLabel() + ", system lb =" + lb);
                            position.setTypeLabel("人脸");
                            position.setLabel("人脸" + ln++);
                            iie.server.Locate.Tag tag = null;
                            if (!"none".equals(locateEntry.getLabel())){
                                ln --;
                                String s = Config.faceTags.get(locateEntry.getLabel());
                                System.out.println("....label...." + locateEntry.getLabel());
                                position.setLabel(s == null ? "" : s);
//                                String s = Config.faceTags.get(locateEntry.getLabel());
//                                position.setLabel(s);
                                System.out.println(getTime() + " 人脸解析结果：" + s);
                                if (s != null && !s.equals("")){
                                    tag = new iie.server.Locate.Tag();
                                    tag.setContent("人脸-" + s);
                                    Tag tg = tagsManager.getLocal().get(s);
                                    if (tg != null){
                                        Integer id = tg.getId();
                                        tag.setId(id);
                                        position.setId(id);
                                    }else {
                                        tag.setId(0);
                                    }
                                }
                            }else{
                                System.out.println(getTime() + " 人脸解析结果：没有标签。");
                            }
                            positions.add(position);
                            locate.setPositions(positions);
                            if (tag != null) {
                                tags.add(tag);
                            }
                        }
                        locate.setTags(tags);
                    }
                    if (lesYolo == null){
                        System.out.println(getTime() + "yolo search timeout!");
                    }else if (lesYolo.getCode().equals("0")){
                        locate.setImgWidth(lesYolo.getW());
                        locate.setImgHeight(lesYolo.getH());
                        Map<String, AtomicInteger> yn = new HashMap<>();
                        for (LocateEntry locateEntry : lesYolo.getLocatesList()) {
                            iie.server.Locate.Position position = new iie.server.Locate.Position();
                            List<Integer> pos = new ArrayList<>();
                            pos.add(0,locateEntry.getX1());
                            pos.add(1,locateEntry.getY1());
                            pos.add(2,locateEntry.getX2());
                            pos.add(3,locateEntry.getY2());
                            pos.add(4,locateEntry.getX3());
                            pos.add(5,locateEntry.getY3());
                            pos.add(6,locateEntry.getX4());
                            pos.add(7,locateEntry.getY4());
                            //TODO://score
                            position.setScore(toFloat2(locateEntry.getSimilarity()));
                            position.setPos(pos);
                            position.setType(locateEntry.getType());
                            String lb = Config.typeTags.get(locateEntry.getLabel());

                            lb = lb == null ? "" : lb;
                            if (yn.get(lb) == null){
                                yn.put(lb, new AtomicInteger(1));
                            } else{
                                yn.get(lb).incrementAndGet();
                            }

                            position.setLabel(lb + yn.get(lb).get());
                            System.out.println(getTime() + " 实体解析结果：" + lb);
                            position.setTypeLabel("实体");
                            positions.add(position);
                            locate.setPositions(positions);
//                            Locate.Tag tag = new Locate.Tag();
//                            tag.setContent(Config.faceTags.get(locateEntry.getLabel()));
//                            //TODO:
//                            tag.setId("test-id");
//                            locate.setTags(tags);
                        }
                    }
                    if (locate.getImgHeight() == 0 && locate.getImgWidth() == 0){
                        InputStream is = HttpRequest.sendGet(url);
                        if (is == null)
                            System.out.println("get url stream = null");
                        else {
                            BufferedImage bs = ImageIO.read(is);
                            System.out.println("image height: " + bs.getHeight());
                            locate.setImgHeight(bs.getHeight());
                            locate.setImgWidth(bs.getWidth());
                        }
                    }
                    locate.setUrl(url);
                    locate.setMd5(md5);
//                    ctx.result(JSON.toJSONString(result));
                    result.put("data", locate);
                    ctx.json(result);
                    System.out.println(getTime() + "请求总耗时: " + (System.currentTimeMillis() - start) + " ms.");
                }else {
                    //other type
                    result.put("message", "暂不支持的类型");
//                    ctx.result(JSON.toJSONString(result));
                    ctx.json(result);
                }
            });
            app.start(Config.httpServerPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文本keywords
     * @param content
     * @return
     */
    private List<Map<String, String>> getKeyWords(String content) {
        List<Map<String, String>> list = new ArrayList<>();
        String rt = null;
//        Map<String, String> params = new HashMap<>();
//        params.put("text", content);
        try {
             rt = OKClientUtils.doPost(Config.keyWordsUrl, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rt != null)
            list = JSON.parseObject(rt, new TypeReference<List<Map<String, String>>>() {});
        return list;
    }

    public static byte[] inputStream2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inputStream.read(buff, 0, 100)) > 0) {
            byteArrayOutputStream.write(buff, 0, rc);
        }
        return byteArrayOutputStream.toByteArray();
    }
    private static String getMd5(byte[] bytes) {
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
    private static long getSimHas(String content){
        return MurmurHash.hash64(content);
    }
    static class Locate {
        List<Integer> pos;
        Integer h;
        Integer w;
        String type;
        String label;
        String url;

        List<String> keyWords = new ArrayList<>();
        String text;
        String md5;
        String simHas;

        public List<Integer> getPos() {
            return pos;
        }

        public void setPos(List<Integer> pos) {
            this.pos = pos;
        }

        public Integer getH() {
            return h;
        }

        public void setH(Integer h) {
            this.h = h;
        }

        public Integer getW() {
            return w;
        }

        public void setW(Integer w) {
            this.w = w;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(List<String> keyWords) {
            this.keyWords = keyWords;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getSimHas() {
            return simHas;
        }

        public void setSimHas(String simHas) {
            this.simHas = simHas;
        }
    }

    private String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
    static class GrpcTask implements Callable{
        String name;
        GrpcClient grpcClient;
        String url;

        public GrpcTask(GrpcClient grpcClient, String url) {
            this.grpcClient = grpcClient;
            this.url = url;
            this.name = grpcClient.getEngineName();
        }

        public String getName() {
            return name;
        }

        @Override
        public LocateEntries call() throws Exception {
            long time1 = System.currentTimeMillis();
            LocateEntries les = grpcClient.getObjectsByUrl(url);
            long time2 = System.currentTimeMillis();
            System.out.println(this.name + " 解析耗时：" + (time2 - time1));
            return les;
        }
    }

    static class HttpTask implements Callable{
        public HttpTask(String url, String name) {
            this.url = url;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        String url;
        String name;
        @Override
        public String call() throws Exception {
            long time1 = System.currentTimeMillis();
            String s = getOcrText(url);
            long time2 = System.currentTimeMillis();
            System.out.println(name + " 耗时: " + (time2 - time1) + " ms.");
           return s;
        }
    }
    public static String getOcrText(String url){
        Map<String, String> map = new HashMap();
        map.put("task_id", "adsfa");
        map.put("type", "jpg");
        map.put("url", url);
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        String param = JSON.toJSONString(list);
        String resultOCR = HttpRequest.sendPost(Config.ocrUrl, param);
        List<Map<String, Object>> mapList = JSON.parseObject(resultOCR, new TypeReference<List<Map<String, Object>>>() {
        });
        Map<String, String> re = (Map<String, String>)mapList.get(0).get("content");
        String tt = re.get("letter");
        return tt;
    }
    private float toFloat2(float f){
        return (float)(Math.round(f*100f)/100f);//如果要求精确4位就*10000然后/10000
    }
}
