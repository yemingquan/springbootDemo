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
 * @创建时间 2020/5/16 10:21
 * @备注
 */
@Data
public class ServiceTemplate extends BaseClassInfo {
    {
        this.setClassNameSuffex(TemplateType01.TYPE01_SERVICE_CLASS_NAME_SUFFEX);
    }

    @Override
    public Map initTemplate(Map map, FileCreater creater) {
        classInfoMap.putAll(map);
        setClassNamePrefix(classInfoMap.get(TemplateType01.TEMPLATE_ACTION_CLASS_NAME_PREFIX_NAME));
        Map<String, String> returnMap = new HashMap<>();

        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_SERVICE_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_SERVICE_CLASS_NAME_01).append(TemplateType01.TYPE01_SERVICE_CLASS_NAME_02);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);

        //field
        StringBuilder fieldListTemplateSb = new StringBuilder(classInfoMap.get("serviceMethodListTemplate"));

        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(fieldListTemplateSb, k, y);
                }
        );

        packagePathTemplate = packagePathTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        fieldListTemplate = fieldListTemplateSb.toString();

        returnMap.put(TemplateType01.TEMPLATE_SERVICE_FILED_CLASS_NAME_NAME, fieldClassName);
        returnMap.put(TemplateType01.TEMPLATE_SERVICE_CLASS_NAME_NAME,className);

        ImportMapper.importMap.put(" "+className+" ", Template01Util.creatImportInfo(className,packagePathTemplate));
        return returnMap;
    }
}
