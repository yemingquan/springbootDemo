package com.example.springBootDemo.controller;

import com.example.springBootDemo.config.parameters.constant.ApiConstant;
import com.example.springBootDemo.model.Student;
import com.example.springBootDemo.model.Student2;
import com.example.springBootDemo.service.IStudentService;
import com.example.springBootDemo.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = {"student", "学生测试接口"})
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    IStudentService service;

    @ApiOperation(value = "学生列表")
    @PostMapping("/list")
    public List<Student> list() throws Exception {
        List<Student> list = service.list();
        return list;
    }

    @ApiOperation(value = "新增学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true),
            @ApiImplicitParam(name = "id", value = "学生id",  dataType = "long")
    })
    @GetMapping("/save")
    public String save(@Valid Student stu) throws Exception {
        service.save(stu);
        return "save success";
    }

    @GetMapping("/del")
    public String del(Long id) throws Exception {
        service.delete(id);
        return "del success";
    }

    @GetMapping("/update")
    public String update(Student stu) throws Exception {
//        Student stu = new Student();
//        stu.setId((long)Math.random());
//        stu.setName("人名"+Math.random());
        service.update(stu);
        return "update success";
    }

    @ApiOperation(value = ApiConstant.DESC_STU_GET_STUDENT_BY_ID)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "我好了，你呢", defaultValue = "1", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "id2", required = true, dataType = "Long")
    })
    @PostMapping(value = ApiConstant.API_STU_GET_STUDENT_BY_ID, name = ApiConstant.DESC_STU_GET_STUDENT_BY_ID)
    public Student get(Long id, Long id2) throws Exception {
        Student stu = service.getStudentById(id);
        return stu;
    }

    /**
     * 注解的测试
     *
     * @param student2
     * @return
     */
    @ApiOperation(value = "对象测试", notes = "这只是一个测试")
//    @ApiImplicitParam(name = "student2", value = "学生对象测试", required = true, dataType = "Student2")
    @PostMapping("/test")
    public Student2 test(@Valid @RequestBody Student2 student2) throws Exception {
        Student student = new Student();
        BeanUtils.copyProperties(student2, student);
        service.update(student);

        Student s2 = Student.builder().id(3l).name("332").build();
        log.info("热交换测试 {}", s2);

        return student2;
    }

    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws Exception {
        List<Student> list = service.list();
        ExcelUtil.exportExcel(list, null, "SheetName", Student.class, "学生信息", response);
    }

    /**
     * 导入
     *
     * @param file
     */
    @PostMapping(value = "/import", name = "学生信息通过Excel导入")
    public void importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        List<Student> personVoList = ExcelUtil.importExcel(file, Student.class);
        log.debug(personVoList.toString());
    }
}
