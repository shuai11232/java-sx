package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Clazz;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("SELECT " +
            "    c.*, " +
            "    e.name AS masterName,"+
            "    CASE " +
            "        WHEN CURDATE() > c.end_date THEN '已结课' " +
            "        WHEN CURDATE() < c.begin_date THEN '未开始' " +
            "        ELSE '已开课' " +
            "    END AS status " +
            "FROM clazz c " +
            "LEFT JOIN emp e ON e.id = c.master_id " +
            "WHERE ${conditions}")
    List<Clazz> list(@Param("conditions") String conditions);

    @Select("SELECT * FROM clazz")
    List<Clazz> listAll();

    @Select("SELECT * FROM clazz WHERE id = #{id}")
    Clazz getById(Integer id);

    @Insert("INSERT INTO clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "VALUES (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Clazz clazz);

    @Update("UPDATE clazz SET name=#{name}, room=#{room}, begin_date=#{beginDate}, end_date=#{endDate}, " +
            "master_id=#{masterId}, subject=#{subject}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Clazz clazz);

    @Delete("DELETE FROM clazz WHERE id = #{id}")
    void deleteById(Integer id);
}
