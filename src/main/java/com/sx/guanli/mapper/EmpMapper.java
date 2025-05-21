package com.sx.guanli.mapper;

import com.sx.guanli.pojo.Emp;
import com.sx.guanli.pojo.EmpDto;
import com.sx.guanli.pojo.EmpExpr;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    @Select("SELECT * FROM emp WHERE ${conditions}")
    List<Emp> list(@Param("conditions") String conditions);

    @Select("SELECT * FROM emp")
    List<Emp> listAll();

    @Select("SELECT * FROM emp WHERE id = #{id}")
    Emp getById(Integer id);

    @Insert("INSERT INTO emp (username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time,phone) " +
            "VALUES (#{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(EmpDto emp);

    @Update("UPDATE emp SET username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, " +
            "job=#{job}, entry_date=#{entryDate}, dept_id=#{deptId}, update_time=#{updateTime} WHERE id=#{id}")
    void update(Emp emp);

    @Delete("DELETE FROM emp WHERE id IN (${ids})")
    void deleteByIds(@Param("ids") String ids);


    List<Map<String, Object>> countEmpJobData();

    List<Map> countEmpGenderData();

    /**
     * 根据用户名和密码查询员工信息
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);

    void insertExpr(List<EmpExpr> exprList);
}
