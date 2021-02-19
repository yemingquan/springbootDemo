package com.example.springBootDemo.model.create.type01;

import com.example.springBootDemo.config.parameters.constant.TemplateType01;
import com.example.springBootDemo.config.parameters.map.ImportMapper;
import com.example.springBootDemo.model.create.BaseClassInfo;
import com.example.springBootDemo.model.create.FileCreater;
import com.example.springBootDemo.util.StringBuilderUtil;
import com.example.springBootDemo.util.Template01Util;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/5/16 10:13
 * @备注
 */
@Data
public class ReqTemplate extends BaseClassInfo {
    {
        this.setClassNameSuffex(TemplateType01.TYPE01_REQ_CLASS_NAME_SUFFEX);
        reqHeadTemplate = new ReqHeadTemplate();
        reqBodyTemplate = new ReqBodyTemplate();
    }

    private ReqHeadTemplate reqHeadTemplate;
    private ReqBodyTemplate reqBodyTemplate;

    @Override
    public Map initTemplate(Map map, FileCreater creater) throws Exception {
        this.classInfoMap.putAll(map);
        setClassNamePrefix(classInfoMap.get(TemplateType01.TEMPLATE_CLASS_NAME_PREFIX_NAME));
        toCreater(creater);
        Map<String, String> returnMap = new HashMap<>();


        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_REQ_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_REQ_CLASS_NAME_SWAGGER).append(TemplateType01.TYPE01_MESSAGE_CLASS_NAME_01).append(TemplateType01.TYPE01_MESSAGE_CLASS_NAME_02);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);

        //field
        StringBuilder fieldListTemplateSb = new StringBuilder();

        StringBuilder fieldTemplateSb = new StringBuilder(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_01).append(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_02).append(TemplateType01.TYPE01_MESSAGE_FIELD_NAME_01);

        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_TYPE_NAME, classInfoMap.get("^reqHeadName$"));
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NAME_NAME, "head");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_ALIAS_FIELD_NAME_NAME, "head");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, "请求头");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_REQUIRE_TYPE_NAME, "true");

        fieldListTemplateSb.append(fieldTemplateSb).append("\n");

        fieldTemplateSb = new StringBuilder(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_01).append(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_02).append(TemplateType01.TYPE01_MESSAGE_FIELD_NAME_01);

        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_TYPE_NAME, classInfoMap.get("^reqBodyName$"));
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NAME_NAME,"body");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_ALIAS_FIELD_NAME_NAME, "body");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, "请求体");
        StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_REQUIRE_TYPE_NAME, "true");

        fieldListTemplateSb.append(fieldTemplateSb);

        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
//                    StringBuilderUtil.replaceAll(importClassTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
//                    StringBuilderUtil.replaceAll(fieldTemplateSb, k, y);
//                    StringBuilderUtil.replaceAll(methodTemplateSb, k, y);
                }
        );

        packagePathTemplate = packagePathTemplateSb.toString();
//        importClassListTemplate = importClassListTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        fieldListTemplate = fieldListTemplateSb.toString();
//        methodListTemplate = methodListTemplateSb.toString();

        returnMap.put(TemplateType01.TEMPLATE_REQ_CLASS_NAME_NAME,className);
        ImportMapper.importMap.put(className+" ", Template01Util.creatImportInfo(className,packagePathTemplate));
        return returnMap;
    }

    @Override
    public void toCreater(FileCreater creater) throws Exception {
        classInfoMap.putAll(reqBodyTemplate.initTemplate(classInfoMap, creater));

        creater.addCreateFile(reqBodyTemplate);
    }
}
