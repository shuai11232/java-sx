package com.sx.guanli.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Log {
    private Integer id;
    private Integer operatorId;
    private String operatorName;
    private String operationType;
    private LocalDateTime operationTime;
    private String requestUrl;
    private String requestMethod;
    private String requestParams;
    private String className;
    private String methodName;
    private String returnValue;
    private Long costTime;
    private String ip;
    private Short status;
    private String errorMsg;
}
