package com.sx.guanli.util;

import com.sx.guanli.pojo.Log;
import com.sx.guanli.pojo.LogDto;

public class TypeUtil {
    public static LogDto toLogDto(Log log) {
        LogDto logDto = new LogDto();
        logDto.setId(log.getId());
        logDto.setOperateEmpId(log.getOperatorId());
        logDto.setOperateEmpName(log.getOperatorName());
        logDto.setOperationType(log.getOperationType());
        logDto.setOperateTime(log.getOperationTime());
        logDto.setRequestUrl(log.getRequestUrl());
        logDto.setRequestMethod(log.getRequestMethod());
        logDto.setMethodParams(log.getRequestParams());
        logDto.setClassName(log.getClassName());
        logDto.setMethodName(log.getMethodName());
        logDto.setReturnValue(log.getReturnValue());
        logDto.setCostTime(log.getCostTime());
        logDto.setIp(log.getIp());
        logDto.setStatus(log.getStatus());
        logDto.setErrorMsg(log.getErrorMsg());
        return logDto;
    }
}
