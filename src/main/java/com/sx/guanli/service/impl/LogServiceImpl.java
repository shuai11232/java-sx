package com.sx.guanli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sx.guanli.mapper.LogMapper;
import com.sx.guanli.pojo.Log;
import com.sx.guanli.pojo.LogDto;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.service.LogService;
import com.sx.guanli.util.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public PageBean<LogDto> page(String operateUsername, String className, String methodName, String begin, String end, Integer page, Integer pageSize) {
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
        //Page<Log> p = (Page<Log>) logMapper.list(whereClause);
        Page<Log> logs = (Page<Log>) logMapper.list(whereClause);
        List<LogDto> logDtoList = new ArrayList<>();
        for(Log log : logs){
            logDtoList.add(TypeUtil.toLogDto(log));
        }
        Page<LogDto> p = new Page<>(logs.getPageNum(), logs.getPageSize());
        p.setTotal(logs.getTotal());
        p.addAll(logDtoList);
        return new PageBean<LogDto>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Log log) {
        logMapper.insert(log);
    }

}
