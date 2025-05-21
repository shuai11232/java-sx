package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
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

    @LogAnnotation(operationType = "查询", operationDesc = "查询部门列表")
    @GetMapping()
    public Result<List<Dept>> list() {
        return Result.success(deptService.list());
    }

    @LogAnnotation(operationType = "新增", operationDesc = "新增部门信息")
    @PostMapping()
    public Result<Void> add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    @LogAnnotation(operationType = "修改", operationDesc = "修改部门信息")
    @PutMapping()
    public Result<Void> update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }

    @LogAnnotation(operationType = "删除", operationDesc = "删除部门信息")
    @DeleteMapping()
    public Result<Void> delete(@RequestParam Integer id) {
        deptService.delete(id);
        return Result.success();
    }

    @LogAnnotation(operationType = "查询", operationDesc = "查询单个部门信息")
    @GetMapping("/{id}")
    public Result<Dept> getById(@PathVariable Integer id) {
        return Result.success(deptService.getById(id));
    }
}
