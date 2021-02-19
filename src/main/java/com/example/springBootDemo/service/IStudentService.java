package com.example.springBootDemo.service;

import com.example.springBootDemo.model.Student;

import java.util.List;

public interface IStudentService {
    void save(Student stu) throws Exception;

    void delete(Long id) throws Exception;

    void update(Student stu) throws Exception;

    Student getStudentById(Long id) throws Exception;

    List<Student> list() throws Exception;

    void truncate() throws Exception;

    void batchSave(int count) throws Exception;
}
