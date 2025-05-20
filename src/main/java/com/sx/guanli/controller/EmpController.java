package com.sx.guanli.controller;

import com.sx.guanli.pojo.Emp;
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

    @GetMapping("/list")
    public Result<List<Emp>> list() {
        return Result.success(empService.list());
    }

    @PostMapping
    public Result<Void> add(@RequestBody Emp emp) {
        empService.add(emp);
        return Result.success(null);
    }

    @PutMapping
    public Result<Void> update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success(null);
    }

    @DeleteMapping()
    public Result<Void> delete(@RequestParam List<Integer> ids) {
        empService.delete(ids);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<Emp> getById(@PathVariable Integer id) {
        return Result.success(empService.getById(id));
    }
}
