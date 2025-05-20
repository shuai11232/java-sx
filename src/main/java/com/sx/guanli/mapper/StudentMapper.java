package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE ${conditions}")
    List<Student> list(@Param("conditions") String conditions);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(Integer id);

    @Insert("INSERT INTO student (name, no, gender, degree, phone, clazz_id, clazz_name, score, create_time, update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{degree}, #{phone}, #{clazzId}, #{clazzName}, #{score}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Update("UPDATE student SET name=#{name}, no=#{no}, gender=#{gender}, degree=#{degree}, " +
            "phone=#{phone}, clazz_id=#{clazzId}, clazz_name=#{clazzName}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Student student);

    @Update("UPDATE student SET score=#{score}, update_time=#{updateTime} WHERE id=#{id}")
    void updateScore(@Param("id") Integer id, @Param("score") Integer score);

    @Select("SELECT degree as name, COUNT(*) as value FROM student GROUP BY degree")
    List<Map<String, Object>> countByDegree();

    @Select("SELECT c.name, COUNT(s.id) as value FROM clazz c LEFT JOIN student s ON c.id = s.clazz_id GROUP BY c.id, c.name")
    List<Map<String, Object>> countByClass();
}
