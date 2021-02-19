package com.example.springBootDemo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.springBootDemo.model.Student2;

public interface IStudent3Service extends IService<Student2> {
    public Page<Student2> selectUserPage(Page<Student2> page, String state);
}
