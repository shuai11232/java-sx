package com.sx.guanli.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.guanli.anno.LogAnnotation;
import com.sx.guanli.mapper.LogMapper;
import com.sx.guanli.pojo.Log;
import com.sx.guanli.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Around("@annotation(com.sx.guanli.anno.LogAnnotation)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 开始时间
        long startTime = System.currentTimeMillis();
        
        // 执行目标方法
        Object result = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            saveLog(joinPoint, startTime, result, e);
            throw e;
        } finally {
            if (result != null) {
                saveLog(joinPoint, startTime, result, null);
            }
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long startTime, Object result, Exception e) {
        try {
            // 结束时间
            long endTime = System.currentTimeMillis();
            
            // 获取请求信息
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            
            // 获取token中的用户信息
            String token = request.getHeader("token");
            Map<String, Object> claims = JwtUtils.parseJWT(token);
            
            // 获取类名和方法名
            String className = joinPoint.getTarget().getClass().getName();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            String methodName = method.getName();
            
            // 创建日志对象
            Log log = new Log();
            
            // 设置操作人信息
            log.setOperatorId((Integer) claims.get("id"));
            log.setOperatorName((String) claims.get("username"));
            
            // 设置操作类型和时间
            LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
            log.setOperationType(logAnnotation.operationType());
            log.setOperationTime(LocalDateTime.now());
            
            // 设置请求信息
            log.setRequestUrl(request.getRequestURI());
            log.setRequestMethod(request.getMethod());
            log.setRequestParams(objectMapper.writeValueAsString(Arrays.toString(joinPoint.getArgs())));
            log.setIp(request.getRemoteAddr());
            
            // 设置类名和方法名
            log.setClassName(className);
            log.setMethodName(methodName);
            
            // 设置返回值
            if (result != null) {
                log.setReturnValue(objectMapper.writeValueAsString(result));
            }
            
            // 设置执行时长
            log.setCostTime(endTime - startTime);
            
            // 设置状态和错误信息
            if (e != null) {
                log.setStatus((short) 2); // 失败
                log.setErrorMsg(e.getMessage());
            } else {
                log.setStatus((short) 1); // 成功
            }
            
            // 保存日志
            logMapper.insert(log);
        } catch (Exception ex) {
            // 记录日志时出现异常，不影响主流程
            ex.printStackTrace();
        }
    }
}
