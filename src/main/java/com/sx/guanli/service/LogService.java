package com.sx.guanli.service;

import com.sx.guanli.pojo.Log;
import com.sx.guanli.pojo.PageBean;

public interface LogService {
    PageBean<Log> page(String operateUsername, String className, String methodName, String begin, String end, Integer page, Integer pageSize);
    
    void add(Log log);
}
