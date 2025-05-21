package com.sx.guanli.pojo;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clazz {
    private Integer id; //ID
    private String name; //班级名称
    private String room; //班级教室
    private LocalDate beginDate; //开课时间
    private LocalDate endDate; //结课时间
    private Integer masterId; //班主任
    private Integer subject; //学科
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    private String masterName; //班主任姓名
    private String status; //班级状态 - 未开班 , 在读 , 已结课


    public Clazz() {
    }

    public Clazz(Integer id, String name, String room, LocalDate beginDate, LocalDate endDate, Integer masterId, Integer subject, LocalDateTime createTime, LocalDateTime updateTime, String masterName, String status) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.masterId = masterId;
        this.subject = subject;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.masterName = masterName;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取
     * @return beginDate
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }

    /**
     * 设置
     * @param beginDate
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * 设置
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取
     * @return masterId
     */
    public Integer getMasterId() {
        return masterId;
    }

    /**
     * 设置
     * @param masterId
     */
    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    /**
     * 获取
     * @return subject
     */
    public Integer getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    /**
     * 获取
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return masterName
     */
    public String getMasterName() {
        return masterName;
    }

    /**
     * 设置
     * @param masterName
     */
    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Clazz{id = " + id + ", name = " + name + ", room = " + room + ", beginDate = " + beginDate + ", endDate = " + endDate + ", masterId = " + masterId + ", subject = " + subject + ", createTime = " + createTime + ", updateTime = " + updateTime + ", masterName = " + masterName + ", status = " + status + "}";
    }
}