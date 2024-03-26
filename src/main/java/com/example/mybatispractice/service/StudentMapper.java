package com.example.mybatispractice.service;

import com.example.mybatispractice.model.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM Student WHERE id = #{id}")
    Student getStudent(Long id);

    @Insert("INSERT INTO Student(firstName,lastName,email,age,district) VALUES(#{firstName}, #{lastName}, #{email}, #{age}, #{district})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertStudent(Student student);

    @Update("UPDATE Student SET firstName = #{firstName},lastName = #{lastName}, email = #{email},age = #{age},district = #{district} WHERE id = #{id}")
    int updateStudent(Student student);

    @Delete("DELETE FROM Student WHERE id = #{id}")
    int deleteStudent(Long id);
}
