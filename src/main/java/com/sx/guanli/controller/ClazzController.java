package com.sx.guanli.controller;

import com.sx.guanli.pojo.Clazz;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result<PageBean<Clazz>> page(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String begin,
            @RequestParam(required = false) String end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<Clazz> pageBean = clazzService.page(name, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @GetMapping("/list")
    public Result<List<Clazz>> list() {
        return Result.success(clazzService.list());
    }

    @PostMapping
    public Result<Void> add(@RequestBody Clazz clazz) {
        clazzService.add(clazz);
        return Result.success(null);
    }

    @PutMapping
    public Result<Void> update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        clazzService.delete(id);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result<Clazz> getById(@PathVariable Integer id) {
        return Result.success(clazzService.getById(id));
    }
}
