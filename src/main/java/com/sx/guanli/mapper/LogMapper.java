package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("SELECT * FROM log WHERE ${conditions}")
    List<Log> list(@Param("conditions") String conditions);

    @Insert("INSERT INTO log (operator_id, operator_name, operation_type, operation_time, request_url, request_method, " +
            "request_params, class_name, method_name, return_value, cost_time, ip, status, error_msg) " +
            "VALUES (#{operatorId}, #{operatorName}, #{operationType}, #{operationTime}, #{requestUrl}, #{requestMethod}, " +
            "#{requestParams}, #{className}, #{methodName}, #{returnValue}, #{costTime}, #{ip}, #{status}, #{errorMsg})")
    void insert(Log log);
}
