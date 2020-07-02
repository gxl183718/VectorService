package iie.test;

import com.alibaba.fastjson.JSON;
import iie.configs.Config;
import iie.grpc.LocateEntries;
import iie.grpc.LocateEntry;
import iie.grpctool.GrpcClient;
import iie.server.Locate;
import iie.tool.TagsManager;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import mammoth.jclient.ClientAPI;
import mammoth.jclient.ImagePHash;
import zzq.dolls.config.LoadConfig;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestYolo {
    public static void main(String[] args) {
        ClientAPI clientAPI = new ClientAPI();
        try {
            LoadConfig.load(Config.class);
            clientAPI.init("STL://10.136.75.17:26379");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GrpcClient clientFace = new GrpcClient(args[0]);
            GrpcClient clientYolo = new GrpcClient(args[1]);

            Javalin app =Javalin.create(config -> {
                config.addStaticFiles("./configs/html", Location.EXTERNAL)
                        .defaultContentType = "application/json;charset=utf-8";
            });

            app.exception(Exception.class, (exception, ctx) -> {
                exception.printStackTrace();
                ctx.result(exception.getMessage());
            });
            //媒体向量查询
            app.post("/yoloQuery", ctx -> {
                String contentType = ctx.formParam("contentType");
                String content = ctx.formParam("content");
                Map<String, Object> result = new HashMap<>();

                result.put("success", true);
                result.put("message", "解析成功");
                result.put("code", 200);

                if ("text".equals(contentType)){
                    Locate locate = new Locate();
                    locate.setSimhash(getSimHas(content));
                    result.put("data", locate);
                    ctx.result(JSON.toJSONString(result));
                }else if ("img".equals(contentType)){
                    String url = null;
                    String md5 = null;
                    if (content == null){
                        InputStream stream = ctx.uploadedFile("file").getContent();
                        byte[] contents = inputStream2byte(stream);
                        md5 = getMd5(contents);
                        String key = "ibc10086@" + md5;
                        clientAPI.put(key, contents);
                        url = "http://10.136.75.20:20099/get?key=" + key;
                    }else {
                        url = content;
                        md5 = url.split("@")[1];
                    }
                    LocateEntries lesFace = clientFace.getObjectsByUrl(url);
                    LocateEntries lesYolo = clientYolo.getObjectsByUrl(url);

                    Locate locate = new Locate();
                    List<Locate.Position> positions = new ArrayList<>();
                    List<Locate.Tag> tags = new ArrayList<>();
                    List<String> keyWords = new ArrayList<>();
                    //face
                    if (lesFace.getCode().equals("0")){
                        for (LocateEntry locateEntry : lesFace.getLocatesList()) {
                            Locate.Position position = new Locate.Position();
                            List<Integer> pos = new ArrayList<>();
                            pos.add(0,locateEntry.getX1());
                            pos.add(1,locateEntry.getY1());
                            pos.add(2,locateEntry.getX2());
                            pos.add(3,locateEntry.getY2());
                            pos.add(4,locateEntry.getX3());
                            pos.add(5,locateEntry.getY3());
                            pos.add(6,locateEntry.getX4());
                            pos.add(7,locateEntry.getY4());
                            position.setPos(pos);
                            position.setType(locateEntry.getType());
                            position.setLabel(Config.faceTags.get(locateEntry.getLabel()));
                            position.setTypeLabel("人脸");
                            positions.add(position);
                            locate.setPositions(positions);
                            Locate.Tag tag = new Locate.Tag();

                            if ("none".equals(locateEntry.getLabel())){

                            }else {
                                String s = Config.faceTags.get(locateEntry.getLabel());
                                if (s != null)
                                    tag.setContent(s);
                            }
                            //TODO:
//                            tag.setId("test-id");
                            tags.add(tag);
                            locate.setTags(tags);
                        }
                        locate.setUrl(url);
                        locate.setMd5(md5);
                        result.put("data", locate);
                    }
                    if (lesYolo.getCode().equals("0")){
                        for (LocateEntry locateEntry : lesYolo.getLocatesList()) {
                            Locate.Position position = new Locate.Position();
                            List<Integer> pos = new ArrayList<>();
                            pos.add(0,locateEntry.getX1());
                            pos.add(1,locateEntry.getY1());
                            pos.add(2,locateEntry.getX2());
                            pos.add(3,locateEntry.getY2());
                            pos.add(4,locateEntry.getX3());
                            pos.add(5,locateEntry.getY3());
                            pos.add(6,locateEntry.getX4());
                            pos.add(7,locateEntry.getY4());
                            position.setPos(pos);
                            position.setType(locateEntry.getType());
                            position.setLabel(Config.typeTags.get(locateEntry.getLabel()));
                            position.setTypeLabel("实体");
                            positions.add(position);
                            locate.setPositions(positions);
//                            Locate.Tag tag = new Locate.Tag();
//                            tag.setContent(Config.faceTags.get(locateEntry.getLabel()));
//                            //TODO:
//                            tag.setId("test-id");
//                            locate.setTags(tags);
                        }
                        locate.setUrl(url);
                        locate.setMd5(md5);
                        result.put("data", locate);
                    }
                    ctx.result(JSON.toJSONString(result));
                }else {
                    //other type
                    result.put("message", "暂不支持的类型");
                    ctx.result(JSON.toJSONString(result));
                }

            });
            app.start(8081);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private static String getSimHas(String content){
        return "this-is-simHash";
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
}
