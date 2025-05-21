package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.pojo.Log;
import com.sx.guanli.pojo.LogDto;
import com.sx.guanli.pojo.PageBean;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @LogAnnotation(operationType = "查询", operationDesc = "分页查询操作日志")
    @GetMapping("/page")
    public Result<PageBean<LogDto>> page(
            @RequestParam(required = false) String operateUsername,
            @RequestParam(required = false) String className,
            @RequestParam(required = false) String methodName,
            @RequestParam(required = false) String begin,
            @RequestParam(required = false) String end,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<LogDto> pageBean = logService.page(operateUsername, className, methodName, begin, end, page, pageSize);
        return Result.success(pageBean);
    }
}
