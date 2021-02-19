package com.example.springBootDemo.service;


import com.example.springBootDemo.SpringBootDemoApplication;
import com.example.springBootDemo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/2/14 14:59
 * @备注
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class test1 {
    @BeforeAll
    public static void init() {
        System.out.println("init once");
    }

    @BeforeEach
    public void each() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void eacha() {
        System.out.println("AfterEach");
    }

    @Ignore("not ready yet")
    @Test
    public void fun1() {
        int res = 1 + 1;
        Assertions.assertEquals("1", "2");
    }


    @Autowired
    IStudentService studentService;

    @Test
    public void t1() {
        try {
            List<Student> list = studentService.list();
            log.info("[{}]", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        IStudentService service = new StudentServiceImpl();

//        System.out.println("t1");
//        Student s = service.getStudentById(1l);
//        Assertions.assertEquals(s.getName(),1);
//        Assert.assertSame("企业数量有误",500,111);
    }
}
