package com.example.springBootDemo.model.create;

import com.example.springBootDemo.config.parameters.constant.BizConstant;
import com.example.springBootDemo.config.parameters.constant.ErrorConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateType01;
import com.example.springBootDemo.config.parameters.map.ImportMapper;
import com.example.springBootDemo.util.FileUtil;
import com.example.springBootDemo.util.SystemUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @所属模块 自动生成
 * @描述 存储基础类信息
 * @创建人 xiaoYe
 * @创建时间 2020/5/15 2:03
 * @备注
 */
@Data
@Slf4j
public abstract class BaseClassInfo {
    {
        importClassList = new ArrayList<>();
        fieldList = new ArrayList<>();
        methodList = new ArrayList<>();
        fieldNoteList = new ArrayList<>();
        fieldNameList = new ArrayList<>();
        fieldValueList = new ArrayList<>();
        fieldTypeList = new ArrayList<>();
        classInfoMap = new HashMap();
        createFlag = false;
        publicFlag = false;

//        importMap = new HashMap();
//        importMap.putAll(ImportMapper.importMap);

    }

//  该字段有生产的时候统一拼接 package字段
    protected String packagePathTemplate;
    protected List<String> importClassList;
//    protected String importClassListTemplate;
    protected String classNameTemplate;
    protected List<String> fieldList;
    protected String fieldListTemplate;
    protected List<String> methodList;
    protected String methodListTemplate;

    protected List<String> fieldNoteList;
    protected List<String> fieldNameList;
    protected List<String> fieldValueList;
    protected List<String> fieldTypeList;

    /**
     * 用于存入公共importMap
     */
//    public static Map<String,String> importMap;

    /**
     * Student
     */
    protected String classNamePrefix;
    /**
     * Controller
     */
    protected String classNameSuffex;
    /**
     * StudentController
     */
    protected String className;
    /**
     * studentController
     */
    protected String fieldClassName;
    /**
     * api中文名
     */
    protected String classChineseName;

    protected String fileClassName;
    protected String filePath;

    protected boolean createFlag;
    protected boolean publicFlag;

    protected Map<String, String> classInfoMap;

    public void setClassNamePrefix(String classNamePrefix) {
        this.classNamePrefix = classNamePrefix;
        className = classNamePrefix + classNameSuffex;
        fieldClassName = classNamePrefix.toLowerCase() + classNameSuffex;
    }

    /**
     * 初始化模板类
     */
    public abstract Map initTemplate(Map classInfoMap, FileCreater creater) throws Exception;

    /**
     * 初始化子类模板类
     */
    public Map initChildTemplate(Map classInfoMap, FileCreater creater) {
        return classInfoMap;
    }

    /**
     * 注册到创造者
     *
     * @param creater
     */
    public void toCreater(FileCreater creater) throws Exception {

    }

    /**
     * 获得外部classInfo 信息
     *
     * @param map
     */
    public void getOutClassInfoMap(Map map) {
        classInfoMap.putAll(map);
    }

    /**
     * 创建文件
     */
    public Boolean createFile() {
        log.info("开始创建类[{}]！", className);
        if (createFlag) {
            log.info("[{}][{}]", className, ErrorConstant.REPEAT_CREATE_INFO);
            return createFlag;
        }
//      import 以下部分
        StringBuffer fileContent2 = new StringBuffer();
        fileContent2.append(classNameTemplate).append("\n");

        if(fieldListTemplate!=null){
            fileContent2.append(fieldListTemplate).append("\n");
        }

        if(methodListTemplate!=null){
            fileContent2.append(methodListTemplate).append("\n");
        }

        fileContent2.append("}");

        StringBuilder importClassListTemplateSb = new StringBuilder();
        ImportMapper.importMap.forEach((k, y) -> {
            if(fileContent2.indexOf(k)!=-1&&!k.trim().equals(className)){
                importClassListTemplateSb.append(y);
            }
        });

//      package+import
        StringBuffer fileContent1 = new StringBuffer();
        fileContent1.append(TemplateType01.TYPE01_PACKAGE_PATH_PREFIX).append(packagePathTemplate).append("\n");
        fileContent1.append(importClassListTemplateSb).append("\n");

        try {
//            log.info(fileContent1+fileContent2.toString());
            FileUtil.createFileByString(fileContent1+fileContent2.toString(), SystemUtil.getClassPath()+"\\src\\main\\java\\"+packagePathTemplate.replace("\n","").replace(".", File.separator).replace(";",File.separator)+className+ TemplateConstant.TEMPLATE_JAVA_FILE_SUFFEX);
            log.info("[{}][{}]", className, BizConstant.CREATE_FILE_SUCCESS_INFO);
            createFlag = true;
        } catch (Exception e) {
            log.info("文件生成异常！[{}]",e.getMessage());
            e.printStackTrace();
            createFlag = false;
        }
        return createFlag;
    }
}
