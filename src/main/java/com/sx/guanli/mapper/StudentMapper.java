package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(@Param("conditions") String conditions);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(Integer id);

    @Insert("INSERT INTO student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Update("UPDATE student SET name=#{name}, no=#{no}, gender=#{gender}, phone=#{phone}, id_card=#{idCard}, is_college=#{isCollege}, address=#{address}, degree=#{degree}, graduation_date=#{graduationDate}, clazz_id=#{clazzId}, violation_count=#{violationCount}, violation_score=#{violationScore}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Student student);

    @Update("UPDATE student SET violation_score=#{score}, update_time=#{updateTime} WHERE id=#{id}")
    void updateScore(@Param("id") Integer id, @Param("score") Integer score, @Param("updateTime") LocalDateTime updateTime);

    @Select("SELECT degree as name, COUNT(*) as value FROM student GROUP BY degree")
    List<Map<String, Object>> countByDegree();

    @Select("SELECT c.name, COUNT(s.id) as value FROM clazz c LEFT JOIN student s ON c.id = s.clazz_id GROUP BY c.id, c.name")
    List<Map<String, Object>> countByClass();

    @Delete("DELETE FROM student WHERE id IN (${ids})")
    void deleteByIds(@Param("ids") String ids);
}
