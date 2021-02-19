package com.example.springBootDemo;

import com.example.springBootDemo.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


//@TestConfiguration
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootDemoApplication.class)
@Slf4j
public class SpringBootDemoApplicationTests {


    @BeforeAll
    static void init() {
        System.out.println("init once");
    }

    @BeforeEach
    void each() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void eacha() {
        System.out.println("AfterEach");
    }

    @Ignore("not ready yet")
    @Test
    void fun1() {
//        int res = 1 + 1;
//        Assertions.assertEquals("1", "2");
    }


    @Autowired
    IStudentService service;

    @Test
    void t1() {
//        IStudentService service = new StudentServiceImpl();

        System.out.println("t1");
//		Student s = service.getStudentById(1l);
//		Assertions.assertEquals(s.getName(),1);
//        Assert.assertSame("企业数量有误",500,111);
    }
}
