package iie.tool;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import iie.configs.Config;
import iie.httptool.OKClientUtils;
import iie.server.YoloHttpServer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-8-26 15:54
 */
public class TagsManager implements Runnable {

    private Map<String, Tag> local = new HashMap<>();

    public Map<String, Tag> getLocal() {
        return local;
    }

    public void setLocal(Map<String, Tag> local) {
        this.local = local;
    }

    @Override
    public void run() {

        Map<String, String> map = new HashMap<>();
        map.put("ids", "13,14,15,16");
        map.put("ifTagIdORTypeId","2");
        map.put("ifTopStoreyIDList","0");
        map.put("lowStorey","0");
        while (true) {
            try {
                String result = OKClientUtils.doGet(Config.tagUrl, map);
                JSONArray data = JSON.parseObject(result).getJSONArray("data");
                List<Tag> tags = data.toJavaList(Tag.class);
                System.out.println(getTime() + "跟新标签列表：");
                for (Tag tag : tags) {
                    //TODO:
                    local.put(tag.getContent() + "", tag);
                    System.out.println("    标签：" + tag.getContent() + " ，id ： " + tag.getId());
                }
                Thread.sleep(1000 * 60 * 60 * 24);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Thread.sleep(1000 * 60 * 10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    private String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
}
