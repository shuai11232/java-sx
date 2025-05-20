package com.sx.guanli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sx.guanli.mapper.ClazzMapper;
import com.sx.guanli.pojo.Clazz;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageBean<Clazz> page(String name, String begin, String end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<String> conditions = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            conditions.add("name LIKE '%" + name + "%'");
        }
        if (begin != null && !begin.isEmpty()) {
            conditions.add("end_date >= '" + begin + "'");
        }
        if (end != null && !end.isEmpty()) {
            conditions.add("end_date <= '" + end + "'");
        }

        String whereClause = conditions.isEmpty() ? "1=1" : String.join(" AND ", conditions);
        Page<Clazz> p = (Page<Clazz>) clazzMapper.list(whereClause);
        
        return new PageBean<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public Page<Clazz> list() {
        PageHelper.startPage(1, 10);
        List<Clazz> clazzList = clazzMapper.listAll();
        return (Page<Clazz>) clazzList;
    }

    @Override
    @Transactional
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(clazz.getCreateTime());
        clazzMapper.insert(clazz);
    }

    @Override
    @Transactional
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }
}
