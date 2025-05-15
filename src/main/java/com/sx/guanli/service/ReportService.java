package com.sx.guanli.service;

import java.util.Map;

public interface ReportService {
    Map<String, Object> getEmpGenderData();
    
    Map<String, Object> getEmpJobData();
    
    Map<String, Object> getStudentDegreeData();
    
    Map<String, Object> getStudentCountData();
}
