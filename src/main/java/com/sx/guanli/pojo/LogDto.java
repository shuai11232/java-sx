package com.sx.guanli.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class LogDto {
    private Integer id;
    private Integer operateEmpId;
    private String operateEmpName;
    private String operationType;
    private LocalDateTime operateTime;
    private String requestUrl;
    private String requestMethod;
    private String methodParams;
    private String className;
    private String methodName;
    private String returnValue;
    private Long costTime;
    private String ip;
    private Short status;
    private String errorMsg;
}
