package com.sx.guanli.pojo;

import java.time.LocalDate;

/**
 * 工作经历
 */
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位


    public EmpExpr() {
    }

    public EmpExpr(Integer id, Integer empId, LocalDate begin, LocalDate end, String company, String job) {
        this.id = id;
        this.empId = empId;
        this.begin = begin;
        this.end = end;
        this.company = company;
        this.job = job;
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
     * @return empId
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * 设置
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * 获取
     * @return begin
     */
    public LocalDate getBegin() {
        return begin;
    }

    /**
     * 设置
     * @param begin
     */
    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    /**
     * 获取
     * @return end
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * 设置
     * @param end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * 获取
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "EmpExpr{id = " + id + ", empId = " + empId + ", begin = " + begin + ", end = " + end + ", company = " + company + ", job = " + job + "}";
    }
}