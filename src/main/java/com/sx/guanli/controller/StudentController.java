package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.pojo.Student;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @LogAnnotation(operationType = "查询", operationDesc = "分页查询学生信息")
    @GetMapping
    public Result<PageBean<Student>> page(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer clazzId,
            @RequestParam(required = false) String degree,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<Student> pageBean = studentService.page(name, clazzId, degree,page, pageSize);
        return Result.success(pageBean);
    }

    @LogAnnotation(operationType = "新增", operationDesc = "新增学生信息")
    @PostMapping
    public Result<Void> add(@RequestBody Student student) {
        if(student.getViolationCount()==null){
            student.setViolationCount((short) 0);
        }
        if(student.getViolationScore()==null){
            student.setViolationScore((short) 0);
        }
        studentService.add(student);
        return Result.success(null);
    }

    @LogAnnotation(operationType = "修改", operationDesc = "修改学生信息")
    @PutMapping
    public Result<Void> update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success(null);
    }

    @LogAnnotation(operationType = "查询", operationDesc = "查询单个学生信息")
    @GetMapping("/{id}")
    public Result<Student> getById(@PathVariable Integer id) {
        return Result.success(studentService.getById(id));
    }

    @LogAnnotation(operationType = "违纪处理", operationDesc = "处理学生违纪情况")
    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.handleViolation(id, score);
        return Result.success();
    }

    @LogAnnotation(operationType = "删除", operationDesc = "删除学生信息")
    @DeleteMapping("/{ids}")
    public Result<Void> delete(@PathVariable String ids) {
        studentService.deleteByIds(ids);
        return Result.success();
    }
}
