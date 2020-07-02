package iie.server;

import com.alibaba.fastjson.JSON;
import iie.test.TextTest;
import okhttp3.*;
import org.apache.commons.fileupload.MultipartStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TextEngine {
    static class DataVector{
        String taskid;
        List<Map<String, String>> data;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public List<Map<String, String>> getData() {
            return data;
        }

        public void setData(List<Map<String, String>> data) {
            this.data = data;
        }
    }
    public static byte[] getTextVector(String content) throws IOException {
        System.out.println("gettext : " + content);
        DataVector data = new DataVector();
        String taskId = System.currentTimeMillis() + "";
        data.setTaskid(taskId);
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("pid", "pid-" + taskId);
        map1.put("m_c", content);
        list.add(map1);
        data.setData(list);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url("http://10.148.17.10:10248/vector_make").post(RequestBody.create(JSON.toJSONString(data), MediaType.parse("application/json"))).build();
        Response response = client.newCall(request).execute();


        ResponseBody body = response.body();
        InputStream inStean = body.byteStream();

        byte[] boundary = "boundary".getBytes();
        MultipartStream multipartStream = new MultipartStream(inStean, boundary);
        boolean nextPart = false;
        String taskid ="";
        int index =1;
        Map<String,Object> message = new HashMap<>();
        byte[] vector = null;
        try {
            nextPart = multipartStream.skipPreamble();
            System.out.println(nextPart);
            while (nextPart) {//不断判断数据，直到结束
                String header = multipartStream.readHeaders(); //拿到头数据
                String pid = "";
                if(index == 1){
                    String[] results = header.replaceAll("\\r","").replaceAll("\\n","").trim().split("_wmh_");
                    taskid = results[0];
                    pid = results[1];
                    index++;
                }else{
                    pid = header.replaceAll("\\r","").replaceAll("\\n","").trim();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                multipartStream.readBodyData(byteArrayOutputStream);
                byte[] bodyy = byteArrayOutputStream.toByteArray();//拿到body的数据
                nextPart = multipartStream.readBoundary();
                System.out.println(getTime() + taskid+" ,"+ pid+","+bodyy.length);
                message.put(pid, bodyy);
                vector = bodyy;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }
    private static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
}
