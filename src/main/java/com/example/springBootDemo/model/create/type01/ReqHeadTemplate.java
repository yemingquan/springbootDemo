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
 * @创建时间 2020/5/16 10:14
 * @备注
 */
@Data
public class ReqHeadTemplate extends BaseClassInfo {
    {
        this.setClassNameSuffex(TemplateType01.TYPE01_REQ_HEAD_CLASS_NAME_SUFFEX);
        fieldNameList.add("token");
        publicFlag = true;
    }

    @Override
    public Map initTemplate(Map map, FileCreater creater) {
        classInfoMap.putAll(map);
        Map<String, String> returnMap = new HashMap<>();
        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_REQ_HEAD_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_REQ_HEAD_CLASS_NAME_SWAGGER).append(TemplateType01.TYPE01_MESSAGE_CLASS_NAME_01).append(TemplateType01.TYPE01_MESSAGE_CLASS_NAME_02);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_API_CHINESE_NAME_NAME, "公共");

        //field
        StringBuilder fieldListTemplateSb = new StringBuilder();

        for (int i = 0; i < fieldNameList.size(); i++) {
            StringBuilder fieldTemplateSb = new StringBuilder(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_01).append(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_02).append(TemplateType01.TYPE01_MESSAGE_FIELD_NAME_01);

            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_TYPE_NAME, "String");
            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NAME_NAME, fieldNameList.get(i));
            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_ALIAS_FIELD_NAME_NAME, fieldNameList.get(i).toUpperCase());
            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, "令牌");
            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_REQUIRE_TYPE_NAME, "true");

            fieldListTemplateSb.append(fieldTemplateSb);
        }

//       替换模板中的元素
        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
//
                }
        );

        packagePathTemplate = packagePathTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        fieldListTemplate = fieldListTemplateSb.toString();

        returnMap.put("^reqHeadName$",className);
        ImportMapper.importMap.put(" "+className+" ", Template01Util.creatImportInfo(className,packagePathTemplate));
        return returnMap;
    }
}
