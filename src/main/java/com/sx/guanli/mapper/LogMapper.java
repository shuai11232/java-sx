package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("SELECT * FROM log WHERE ${conditions}")
    List<Log> list(@Param("conditions") String conditions);

    @Insert("INSERT INTO log (operate_user, operate_username, class_name, method_name, method_params, return_value, cost_time, create_time) " +
            "VALUES (#{operateUser}, #{operateUsername}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime}, #{createTime})")
    void insert(Log log);
}
