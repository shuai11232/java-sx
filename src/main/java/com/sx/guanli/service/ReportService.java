package com.sx.guanli.service;

import com.sx.guanli.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    /**
     * 统计学员的学历信息
     */
    List<Map<String, Object>> getStudentDegreeData();

    /**
     * 统计每个班级的人数
     */
    Map<String, Object> getStudentCountData();
}
