package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.pojo.Emp;
import com.sx.guanli.pojo.EmpDto;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @LogAnnotation(operationType = "查询", operationDesc = "分页查询员工信息")
    @GetMapping
    public Result<PageBean<Emp>> page(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Short gender,
            @RequestParam(required = false) String begin,
            @RequestParam(required = false) String end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<Emp> pageBean = empService.page(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @LogAnnotation(operationType = "查询", operationDesc = "查询员工列表")
    @GetMapping("/list")
    public Result<List<Emp>> list() {
        return Result.success(empService.list());
    }

    @LogAnnotation(operationType = "新增", operationDesc = "新增员工信息")
    @PostMapping
    public Result<Void> add(@RequestBody EmpDto empDto) {
        empService.add(empDto);
        return Result.success(null);
    }

    @LogAnnotation(operationType = "修改", operationDesc = "修改员工信息")
    @PutMapping
    public Result<Void> update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success(null);
    }

    @LogAnnotation(operationType = "删除", operationDesc = "删除员工信息")
    @DeleteMapping()
    public Result<Void> delete(@RequestParam List<Integer> ids) {
        empService.delete(ids);
        return Result.success(null);
    }

    @LogAnnotation(operationType = "查询", operationDesc = "查询单个员工信息")
    @GetMapping("/{id}")
    public Result<Emp> getById(@PathVariable Integer id) {
        return Result.success(empService.getById(id));
    }
}
