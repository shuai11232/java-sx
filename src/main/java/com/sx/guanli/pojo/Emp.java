package com.sx.guanli.pojo;



import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    private Integer id; //ID,主键
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Integer gender; //性别, 1:男, 2:女
    private String phone; //手机号
    private Integer job; //职位, 1:班主任,2:讲师,3:学工主管,4:教研主管,5:咨询师
    private Integer salary; //薪资
    private String image; //头像
    private LocalDate entryDate; //入职日期
    private Integer deptId; //关联的部门ID
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

    //封装部门名称
    private String deptName; //部门名称


    public Emp() {
    }

    public Emp(Integer id, String username, String password, String name, Integer gender, String phone, Integer job, Integer salary, String image, LocalDate entryDate, Integer deptId, LocalDateTime createTime, LocalDateTime updateTime, String deptName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.job = job;
        this.salary = salary;
        this.image = image;
        this.entryDate = entryDate;
        this.deptId = deptId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deptName = deptName;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return job
     */
    public Integer getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(Integer job) {
        this.job = job;
    }

    /**
     * 获取
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * 获取
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取
     * @return entryDate
     */
    public LocalDate getEntryDate() {
        return entryDate;
    }

    /**
     * 设置
     * @param entryDate
     */
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * 获取
     * @return deptId
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String toString() {
        return "Emp{id = " + id + ", username = " + username + ", password = " + password + ", name = " + name + ", gender = " + gender + ", phone = " + phone + ", job = " + job + ", salary = " + salary + ", image = " + image + ", entryDate = " + entryDate + ", deptId = " + deptId + ", createTime = " + createTime + ", updateTime = " + updateTime + ", deptName = " + deptName + "}";
    }
}