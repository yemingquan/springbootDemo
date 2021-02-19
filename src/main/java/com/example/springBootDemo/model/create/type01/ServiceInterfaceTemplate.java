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
 * @创建时间 2020/5/16 10:11
 * @备注
 */
@Data
public class ServiceInterfaceTemplate extends BaseClassInfo {
    {
        this.setClassNameSuffex(TemplateType01.TYPE01_SERVICE_INTERFACE_CLASS_NAME_SUFFEX);
        serviceTemplate = new ServiceTemplate();
    }

    private ServiceTemplate serviceTemplate;

    @Override
    public Map initTemplate(Map map, FileCreater creater) throws Exception {
        classInfoMap.putAll(map);
        setClassNamePrefix("I"+classInfoMap.get(TemplateType01.TEMPLATE_ACTION_CLASS_NAME_PREFIX_NAME));
        Map<String, String> returnMap = new HashMap<>();

        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_SERVICE_INTERFACE_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_ISERVICE_CLASS_NAME);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);

        // method
        StringBuilder methodTemplateListSb = new StringBuilder(methodListTemplate);

        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(methodTemplateListSb, k, y);
                }
        );

        packagePathTemplate = packagePathTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        methodListTemplate = methodTemplateListSb.toString();


        classInfoMap.put(TemplateType01.TEMPLATE_I_SERVICE_CLASS_NAME_NAME,className);
        ImportMapper.importMap.put(" "+className+" ", Template01Util.creatImportInfo(className,packagePathTemplate));

        returnMap.put(TemplateType01.TEMPLATE_I_SERVICE_CLASS_NAME_NAME,classInfoMap.get(TemplateType01.TEMPLATE_I_SERVICE_CLASS_NAME_NAME));
        returnMap.putAll(serviceTemplate.initTemplate(classInfoMap, creater));
        toCreater(creater);
        return returnMap;
    }

    @Override
    public void toCreater(FileCreater creater) throws Exception {
        creater.addCreateFile(serviceTemplate);
    }
}
