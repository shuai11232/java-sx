package com.sx.guanli.service.impl;

import com.sx.guanli.mapper.EmpMapper;
import com.sx.guanli.mapper.StudentMapper;
import com.sx.guanli.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Map<String, Object> getEmpGenderData() {
        List<Map<String, Object>> data = empMapper.countByGender();
        return new HashMap<String, Object>() {{
            put("data", data);
        }};
    }

    @Override
    public Map<String, Object> getEmpJobData() {
        List<Map<String, Object>> data = empMapper.countByJob();
        return new HashMap<String, Object>() {{
            put("data", data);
        }};
    }

    @Override
    public Map<String, Object> getStudentDegreeData() {
        List<Map<String, Object>> data = studentMapper.countByDegree();
        return new HashMap<String, Object>() {{
            put("data", data);
        }};
    }

    @Override
    public Map<String, Object> getStudentCountData() {
        List<Map<String, Object>> data = studentMapper.countByClass();
        return new HashMap<String, Object>() {{
            put("data", data);
        }};
    }
}
