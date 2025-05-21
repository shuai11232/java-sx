package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.pojo.JobOption;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
public class ReportController {
    //请帮我生成一个 日志对象
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @LogAnnotation(operationType = "统计", operationDesc = "查询职位员工人数统计数据")
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @LogAnnotation(operationType = "统计", operationDesc = "查询员工性别统计数据")
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计学员的学历信息
     */
    @LogAnnotation(operationType = "统计", operationDesc = "查询学生学位统计数据")
    @GetMapping("/studentDegreeData")
    public Result<List<Map<String, Object>>> getStudentDegreeData() {
        log.info("统计学员的学历信息");
        List<Map<String, Object>> degreeData = reportService.getStudentDegreeData();
        return Result.success(degreeData);
    }

    /**
     * 统计每个班级的人数
     */
    @LogAnnotation(operationType = "统计", operationDesc = "查询学生班级人数统计数据")
    @GetMapping("/studentCountData")
    public Result<Map<String, Object>> getStudentCountData() {
        log.info("统计每个班级的人数");
        Map<String, Object> countData = reportService.getStudentCountData();
        return Result.success(countData);
    }
}