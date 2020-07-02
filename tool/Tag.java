package iie.tool;

import java.util.ArrayList;
import java.util.List;


public class Tag {
    private Integer id;

    private Integer oneLevelType;

    private Integer twoLevelType;

    private Long aliveStartTime;

    private Long aliveEndTime;

    private Integer createUser;

    private Integer updateUser;

    private Long updateTime;

    private String content;

    private String desc;

    private String tops;

    private Integer sysId;

    private Integer status;

    private Integer ifPolymerize;

    private String ownUsergroups;

    private int ownUser;

    private List<Tag> children = new ArrayList<>();

    private List<Integer> topChildrenIds = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOneLevelType() {
        return oneLevelType;
    }

    public void setOneLevelType(Integer oneLevelType) {
        this.oneLevelType = oneLevelType;
    }

    public Integer getTwoLevelType() {
        return twoLevelType;
    }

    public void setTwoLevelType(Integer twoLevelType) {
        this.twoLevelType = twoLevelType;
    }

    public Long getAliveStartTime() {
        return aliveStartTime;
    }

    public void setAliveStartTime(Long aliveStartTime) {
        this.aliveStartTime = aliveStartTime;
    }

    public Long getAliveEndTime() {
        return aliveEndTime;
    }

    public void setAliveEndTime(Long aliveEndTime) {
        this.aliveEndTime = aliveEndTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTops() {
        return tops;
    }

    public void setTops(String tops) {
        this.tops = tops;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIfPolymerize() {
        return ifPolymerize;
    }

    public void setIfPolymerize(Integer ifPolymerize) {
        this.ifPolymerize = ifPolymerize;
    }

    public String getOwnUsergroups() {
        return ownUsergroups;
    }

    public void setOwnUsergroups(String ownUsergroups) {
        this.ownUsergroups = ownUsergroups;
    }

    public int getOwnUser() {
        return ownUser;
    }

    public void setOwnUser(int ownUser) {
        this.ownUser = ownUser;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    public List<Integer> getTopChildrenIds() {
        return topChildrenIds;
    }

    public void setTopChildrenIds(List<Integer> topChildrenIds) {
        this.topChildrenIds = topChildrenIds;
    }
}