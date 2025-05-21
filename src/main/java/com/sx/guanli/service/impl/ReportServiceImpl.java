package com.sx.guanli.service.impl;

import com.sx.guanli.mapper.EmpMapper;
import com.sx.guanli.mapper.StudentMapper;
import com.sx.guanli.pojo.JobOption;
import com.sx.guanli.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countByDegree();
    }

    @Override
    public Map<String, Object> getStudentCountData() {
        List<Map<String, Object>> countData = studentMapper.countByClass();

        // 提取班级名称和人数列表
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();

        for (Map<String, Object> data : countData) {
            clazzList.add((String) data.get("name"));
            dataList.add(((Number) data.get("value")).intValue());
        }

        // 构建返回的数据格式
        Map<String, Object> result = new HashMap<>();
        result.put("clazzList", clazzList);
        result.put("dataList", dataList);

        return result;
    }
}
