package com.sx.guanli.service;

import com.sx.guanli.pojo.Student;
import com.sx.guanli.pojo.PageBean;

public interface StudentService {
    PageBean<Student> page(String name, Integer clazzId, String degree,Integer page, Integer pageSize);
    
    void add(Student student);
    
    void update(Student student);
    
    Student getById(Integer id);
    
    void handleViolation(Integer id, Integer score);

    void deleteByIds(String ids);
}
