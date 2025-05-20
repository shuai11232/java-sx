package com.sx.guanli.controller;

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

    @GetMapping
    public Result<PageBean<Student>> page(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer clazzId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<Student> pageBean = studentService.page(name, clazzId, page, pageSize);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result<Void> add(@RequestBody Student student) {
        studentService.add(student);
        return Result.success(null);
    }

    @PutMapping
    public Result<Void> update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<Student> getById(@PathVariable Integer id) {
        return Result.success(studentService.getById(id));
    }

    @PutMapping("/violation/{id}/{score}")
    public Result<Void> handleViolation(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.handleViolation(id, score);
        return Result.success(null);
    }
}
