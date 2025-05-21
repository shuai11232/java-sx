package com.sx.guanli.service;

import com.sx.guanli.pojo.Emp;
import com.sx.guanli.pojo.EmpDto;
import com.sx.guanli.pojo.LoginInfo;
import com.sx.guanli.pojo.PageBean;

import java.util.List;

public interface EmpService {
    PageBean<Emp> page(String name, Short gender, String begin, String end, Integer page, Integer pageSize);
    
    List<Emp> list();
    
    void add(EmpDto empDto);
    
    void update(Emp emp);
    
    void delete(List<Integer> ids);
    
    Emp getById(Integer id);

    LoginInfo login(Emp emp);
}
