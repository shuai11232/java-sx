package com.sx.guanli.controller;

import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empGenderData")
    public Result<Map<String, Object>> empGenderData() {
        return Result.success(reportService.getEmpGenderData());
    }

    @GetMapping("/empJobData")
    public Result<Map<String, Object>> empJobData() {
        return Result.success(reportService.getEmpJobData());
    }

    @GetMapping("/studentDegreeData")
    public Result<Map<String, Object>> studentDegreeData() {
        return Result.success(reportService.getStudentDegreeData());
    }

    @GetMapping("/studentCountData")
    public Result<Map<String, Object>> studentCountData() {
        return Result.success(reportService.getStudentCountData());
    }
}
