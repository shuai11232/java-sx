package com.sx.guanli.controller;

import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.pojo.Emp;
import com.sx.guanli.pojo.LoginInfo;
import com.sx.guanli.pojo.Result;
import com.sx.guanli.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @LogAnnotation(operationType = "登录", operationDesc = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工来登录啦 , {}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误~");
    }

}