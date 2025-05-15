package com.sx.guanli.service;

import com.sx.guanli.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void add(Dept dept);

    void update(Dept dept);

    void delete(Integer id);

    Dept getById(Integer id);
}