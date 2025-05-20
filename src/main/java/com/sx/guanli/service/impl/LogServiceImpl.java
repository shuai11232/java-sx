package com.sx.guanli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sx.guanli.mapper.LogMapper;
import com.sx.guanli.pojo.Log;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public PageBean<Log> page(String operateUsername, String className, String methodName, String begin, String end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<String> conditions = new ArrayList<>();
        if (operateUsername != null && !operateUsername.isEmpty()) {
            conditions.add("operate_username LIKE '%" + operateUsername + "%'");
        }
        if (className != null && !className.isEmpty()) {
            conditions.add("class_name LIKE '%" + className + "%'");
        }
        if (methodName != null && !methodName.isEmpty()) {
            conditions.add("method_name LIKE '%" + methodName + "%'");
        }
        if (begin != null && !begin.isEmpty()) {
            conditions.add("create_time >= '" + begin + "'");
        }
        if (end != null && !end.isEmpty()) {
            conditions.add("create_time <= '" + end + "'");
        }

        String whereClause = conditions.isEmpty() ? "1=1" : String.join(" AND ", conditions);
        Page<Log> p = (Page<Log>) logMapper.list(whereClause);
        
        return new PageBean<Log>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Log log) {
        logMapper.insert(log);
    }

}
