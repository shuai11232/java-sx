package com.sx.guanli.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private Integer id; //ID
    private String name; //姓名
    private String no; //序号
    private Integer gender; //性别 , 1: 男 , 2 : 女
    private String phone; //手机号
    private String idCard; //身份证号
    private Integer isCollege; //是否来自于院校, 1: 是, 0: 否
    private String address; //联系地址
    private Integer degree; //最高学历, 1: 初中, 2: 高中 , 3: 大专 , 4: 本科 , 5: 硕士 , 6: 博士
    private LocalDate graduationDate; //毕业时间
    private Integer clazzId; //班级ID
    private Short violationCount; //违纪次数
    private Short violationScore; //违纪扣分
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    private String clazzName;//班级名称


    public Student() {
    }

    public Student(Integer id, String name, String no, Integer gender, String phone, String idCard, Integer isCollege, String address, Integer degree, LocalDate graduationDate, Integer clazzId, Short violationCount, Short violationScore, LocalDateTime createTime, LocalDateTime updateTime, String clazzName) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
        this.isCollege = isCollege;
        this.address = address;
        this.degree = degree;
        this.graduationDate = graduationDate;
        this.clazzId = clazzId;
        this.violationCount = violationCount;
        this.violationScore = violationScore;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.clazzName = clazzName;
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
     * @return no
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置
     * @param no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return isCollege
     */
    public Integer getIsCollege() {
        return isCollege;
    }

    /**
     * 设置
     * @param isCollege
     */
    public void setIsCollege(Integer isCollege) {
        this.isCollege = isCollege;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return degree
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * 设置
     * @param degree
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    /**
     * 获取
     * @return graduationDate
     */
    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    /**
     * 设置
     * @param graduationDate
     */
    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * 获取
     * @return clazzId
     */
    public Integer getClazzId() {
        return clazzId;
    }

    /**
     * 设置
     * @param clazzId
     */
    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * 获取
     * @return violationCount
     */
    public Short getViolationCount() {
        return violationCount;
    }

    /**
     * 设置
     * @param violationCount
     */
    public void setViolationCount(Short violationCount) {
        this.violationCount = violationCount;
    }

    /**
     * 获取
     * @return violationScore
     */
    public Short getViolationScore() {
        return violationScore;
    }

    /**
     * 设置
     * @param violationScore
     */
    public void setViolationScore(Short violationScore) {
        this.violationScore = violationScore;
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
     * @return clazzName
     */
    public String getClazzName() {
        return clazzName;
    }

    /**
     * 设置
     * @param clazzName
     */
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", no = " + no + ", gender = " + gender + ", phone = " + phone + ", idCard = " + idCard + ", isCollege = " + isCollege + ", address = " + address + ", degree = " + degree + ", graduationDate = " + graduationDate + ", clazzId = " + clazzId + ", violationCount = " + violationCount + ", violationScore = " + violationScore + ", createTime = " + createTime + ", updateTime = " + updateTime + ", clazzName = " + clazzName + "}";
    }
}