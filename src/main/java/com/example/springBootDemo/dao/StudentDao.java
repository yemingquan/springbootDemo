package com.example.springBootDemo.dao;

import com.example.springBootDemo.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentDao {
    //添加
    @Insert("INSERT INTO biz_student(id,name) values(#{id},#{name})")
    void save(Student stu);

    //删除
    @Delete("DELETE FROM biz_student where id=#{id}")
    void delete(Long id);

    //修改
    @Update("UPDATE biz_student set name=#{name} where id=#{id}")
    void update(Student stu);

    //查询单个
    @Select("SELECT * FROM biz_student where id=#{id}")
    Student get(Long id);

    //查询多个
    @Select("SELECT * FROM biz_student")
    List<Student> list();

    //学生毕业了
    @Delete("TRUNCATE TABLE biz_student")
    void truncate();
}
