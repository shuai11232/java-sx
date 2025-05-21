package com.sx.guanli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sx.guanli.mapper.StudentMapper;
import com.sx.guanli.pojo.Student;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageBean<Student> page(String name, Integer clazzId, String degree,Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<String> conditions = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            conditions.add("name LIKE '%" + name + "%'");
        }
        if (clazzId != null) {
            conditions.add("(clazz_id = " + clazzId + " OR clazz_id IS NULL)");
        }
        if(degree != null && !degree.isEmpty()){
            conditions.add("(degree = '" + degree + "' OR degree IS NULL)");
        }
        String whereClause = conditions.isEmpty() ? "1=1" : String.join(" AND ", conditions);
        Page<Student> p = (Page<Student>) studentMapper.list(whereClause);
        
        return new PageBean<Student>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(student.getCreateTime());
        studentMapper.insert(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void handleViolation(Integer id, Integer score) {
        LocalDateTime updateTime = LocalDateTime.now();
        studentMapper.updateScore(id, score,updateTime);
    }

    @Override
    public void deleteByIds(String ids) {
        studentMapper.deleteByIds(ids);
    }
}
