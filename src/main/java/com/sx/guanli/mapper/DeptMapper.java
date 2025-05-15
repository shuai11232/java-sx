package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Dept dept);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);
}
