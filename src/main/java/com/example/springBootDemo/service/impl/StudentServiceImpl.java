package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.config.parameters.annotation.MethodAnnotation;
import com.example.springBootDemo.config.parameters.constant.ApiConstant;
import com.example.springBootDemo.dao.StudentDao;
import com.example.springBootDemo.model.Student;
import com.example.springBootDemo.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentDao dao;

    @Override
    @MethodAnnotation(methodName = "新增学生")
    public void save(Student stu) {
        dao.save(stu);
    }

    @Override
    @MethodAnnotation()
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @MethodAnnotation(methodName = "修改学生信息")
    public void update(Student stu) {
        dao.update(stu);
    }

    @Override
    @MethodAnnotation(methodName = ApiConstant.DESC_STU_GET_STUDENT_BY_ID)
    public Student getStudentById(Long id) {
        return dao.get(id);
    }

    @Override
    @MethodAnnotation(methodName = ApiConstant.DESC_PAGE_TEST)
    public List<Student> list() {
        return dao.list();
    }

    @Override
    @MethodAnnotation(methodName = "清空学生表数据")
    public void truncate() {
        dao.truncate();
    }

    @Override
    @MethodAnnotation(methodName = "批量插入学生信息")
    public void batchSave(int count) throws Exception {
        for (long i = 1; i <= count; i++) {
            Student s = Student.builder().name("量产机" + i).build();
            save(s);
        }
    }
}
