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
 * @创建时间 2020/5/16 10:18
 * @备注
 */
@Data
public class ConfigTemplate extends BaseClassInfo {
    {
        this.setClassNameSuffex(TemplateType01.TYPE01_CONFIG_CLASS_NAME_SUFFEX);
        publicFlag = true;
    }

    @Override
    public Map initTemplate(Map map, FileCreater creater) {
        classInfoMap.putAll(map);
        Map<String, String> returnMap = new HashMap<>();
        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_CONFIG_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_MESSAGE_CLASS_NAME_02);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);

        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
                }
        );

        //field
        StringBuilder fieldListTemplateSb = new StringBuilder();

        for (int i = 0; i < fieldNameList.size(); i++) {
            StringBuilder fieldTemplateSb = new StringBuilder(TemplateType01.TYPE01_CONFIG_FIELD_NAME_01);
            StringBuilder fieldTemplateSb2 = new StringBuilder(TemplateType01.TYPE01_CONFIG_FIELD_NAME_02);

            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_NAME_NAME, fieldNameList.get(i));
            StringBuilderUtil.replaceAll(fieldTemplateSb, TemplateType01.TEMPLATE_FIELD_VALUE_NAME, fieldValueList.get(i));

            StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_NAME_NAME, fieldNameList.get(i));
            StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, fieldNoteList.get(i));

            fieldListTemplateSb.append(fieldTemplateSb);
            fieldListTemplateSb.append(fieldTemplateSb2);
        }

        packagePathTemplate = packagePathTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        fieldListTemplate = fieldListTemplateSb.toString();

        returnMap.put(TemplateType01.TEMPLATE_CONFIG_CLASS_NAME_NAME,className);
        returnMap.put(TemplateType01.TEMPLATE_CONFIG_FIELD_VALUE_NAME, fieldClassName);
        returnMap.put(TemplateType01.TEMPLATE_CONFIG_DESC_FIELD_NAME_NAME,classChineseName);
        ImportMapper.importMap.put(className, Template01Util.creatImportInfo(className,packagePathTemplate));
        return returnMap;
    }
}
