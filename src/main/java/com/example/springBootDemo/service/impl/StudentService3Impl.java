package com.example.springBootDemo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.springBootDemo.dao.StudentMapper;
import com.example.springBootDemo.model.Student2;
import com.example.springBootDemo.service.IStudent3Service;
import org.springframework.stereotype.Service;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/7/16 21:30
 * @备注
 */
@Service("StudentService3Impl")
public class StudentService3Impl extends ServiceImpl<StudentMapper, Student2> implements IStudent3Service {

    public Page<Student2> selectUserPage(Page<Student2> page, String state) {
        page.setRecords(baseMapper.selectUserList(page,state));
        return page;
    }
}
