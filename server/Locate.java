package iie.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Locate {
    List<Map<String, String>> keyWords = new ArrayList<>();
    List<Tag> tags = new ArrayList<>();
    List<Position> positions = new ArrayList<>();
    Integer imgWidth = 0;
    Integer imgHeight = 0;
    String url = "";
    String text = "";
    String md5 = "";
    String simhash = "";

    public List<Map<String, String>> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<Map<String, String>> keyWords) {
        this.keyWords = keyWords;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getSimhash() {
        return simhash;
    }

    public void setSimhash(String simhash) {
        this.simhash = simhash;
    }

    public static class Tag{
        Integer id;
        String content;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
    public static class Position{
        String type = "";//引擎
        String typeLabel = "";//引擎-汉语
        String label = "";//标签-汉语
        Integer id = 0;
        List<Integer> pos = new ArrayList<>();
        Float score = 0.0f;

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getTypeLabel() {
            return typeLabel;
        }

        public void setTypeLabel(String typeLabel) {
            this.typeLabel = typeLabel;
        }

        public List<Integer> getPos() {
            return pos;
        }

        public void setPos(List<Integer> pos) {
            this.pos = pos;
        }
    }

}
