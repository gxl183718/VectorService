package iie.test;

import com.alibaba.fastjson.JSON;
import iie.httptool.OKClientUtils;
import okhttp3.*;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.pulsar.shade.io.swagger.annotations.ResponseHeader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TextTest {

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

    public static void main(String[] args) throws IOException {

        DataVector data = new DataVector();
        data.setTaskid("10010");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("pid", "pid-10010");
        map1.put("m_c", "what the fuck!你好呀，习近平总书记。");
        Map<String, String> map2 = new HashMap<>();
        map2.put("pid", "pid-10011");
        map2.put("m_c", "王岐山和温家宝，得得得得，好好好，中国共产党万岁。");
        list.add(map1);
        list.add(map2);
        data.setData(list);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url(args[0]).post(RequestBody.create(JSON.toJSONString(data), MediaType.parse("application/json"))).build();
        Response response = client.newCall(request).execute();


        ResponseBody body = response.body();
        InputStream inStean = body.byteStream();

        byte[] boundary = "boundary".getBytes();
        MultipartStream multipartStream = new MultipartStream(inStean, boundary);
        boolean nextPart = false;
        String taskid ="";

        int index =1;

        try {
            nextPart = multipartStream.skipPreamble();
            System.out.println(nextPart);
            while (nextPart) {//不断判断数据，直到结束
                Map<String,Object> message = new HashMap<>();
                String header = multipartStream.readHeaders(); //拿到头数据
                String pid = "";
                if(index == 1){
                    System.out.println(header+"----------------------------");
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
                System.out.println(taskid+" -- --"+ pid+"-- --"+bodyy.length);
                nextPart = multipartStream.readBoundary();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
