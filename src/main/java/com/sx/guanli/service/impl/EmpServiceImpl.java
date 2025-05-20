package com.sx.guanli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sx.guanli.mapper.EmpMapper;
import com.sx.guanli.pojo.Emp;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean<Emp> page(String name, Short gender, String begin, String end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<String> conditions = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            conditions.add("name LIKE '%" + name + "%'");
        }
        if (gender != null) {
            conditions.add("gender = " + gender);
        }
        if (begin != null && !begin.isEmpty()) {
            conditions.add("entry_date >= '" + begin + "'");
        }
        if (end != null && !end.isEmpty()) {
            conditions.add("entry_date <= '" + end + "'");
        }

        String whereClause = conditions.isEmpty() ? "1=1" : String.join(" AND ", conditions);
        Page<Emp> p = (Page<Emp>) empMapper.list(whereClause);
        
        return new PageBean<Emp>(p.getTotal(), p.getResult());
    }

    @Override
    public Page<Emp> list() {
        PageHelper.startPage(1, 10);
        List<Emp> empList = empMapper.listAll();
        return (Page<Emp>) empList;
    }

    @Override
    @Transactional
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(emp.getCreateTime());
        empMapper.insert(emp);
    }

    @Override
    @Transactional
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {
        String idStr = String.join(",", ids.stream().map(String::valueOf).toList());
        empMapper.deleteByIds(idStr);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }
}
