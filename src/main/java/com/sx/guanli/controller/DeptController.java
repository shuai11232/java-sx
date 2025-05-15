package com.sx.guanli.controller;

import com.sx.guanli.pojo.Dept;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping()
    public Result<List<Dept>> list() {
        return Result.success(deptService.list());
    }

    @PostMapping()
    public Result<Void> add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping()
    public Result<Void> update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }

    @DeleteMapping()
    public Result<Void> delete(@RequestParam Integer id) {
        deptService.delete(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Dept> getById(@PathVariable Integer id) {
        return Result.success(deptService.getById(id));
    }
}
