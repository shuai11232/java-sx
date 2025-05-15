package com.sx.guanli.service;

import com.sx.guanli.pojo.Clazz;
import com.sx.guanli.pojo.PageBean;

import java.util.List;

public interface ClazzService {
    PageBean<Clazz> page(String name, String begin, String end, Integer page, Integer pageSize);
    
    List<Clazz> list();
    
    void add(Clazz clazz);
    
    void update(Clazz clazz);
    
    void delete(Integer id);
    
    Clazz getById(Integer id);
}
