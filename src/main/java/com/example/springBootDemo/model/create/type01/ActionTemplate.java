package com.example.springBootDemo.model.create.type01;

import com.example.springBootDemo.config.parameters.constant.SystemConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateType01;
import com.example.springBootDemo.model.create.BaseClassInfo;
import com.example.springBootDemo.model.create.FileCreater;
import com.example.springBootDemo.util.StringBuilderUtil;
import com.example.springBootDemo.util.Template01Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

/**
 * @所属模块 自动生成
 * @描述 接口模板类
 * @创建人 xiaoYe
 * @创建时间 2020/5/16 10:08
 * @备注
 */
@Data
@Slf4j
public class ActionTemplate extends BaseClassInfo {

    {
        this.setClassNameSuffex(TemplateType01.TYPE01_ACTION_CLASS_NAME_SUFFEX);

    }

    private ServiceInterfaceTemplate serviceInterfaceTemplate;
    private ReqTemplate reqTemplate;
    private ResTemplate resTemplate;

    //  这个方法的classInfoMap 与其他Action的map无关
    @Override
    public Map initTemplate(Map map, FileCreater creater) throws Exception {
        classInfoMap.putAll(map);

        toCreater(creater);

        return this.classInfoMap;
    }

    @Override
    public void toCreater(FileCreater creater) throws Exception {
        //field
        StringBuilder fieldListTemplateSb = new StringBuilder();
        StringBuilder iServiceMethodListTemplateSb = new StringBuilder();
        StringBuilder serviceMethodListTemplateSb = new StringBuilder();
        StringBuilder actionListTemplateSb = new StringBuilder();

        for (int i = 0; i < methodList.size(); i++) {
            String methodName = methodList.get(i);

//          将原method字段  AGT_ADD_ACTIVATION_ALL 转换
            String actionMechodName = upperInitialName(changeApiNameToCodeName(methodName, 1), false);
            String aaaclassNamePrefix = upperInitialName(actionMechodName, true);
            classInfoMap.put(TemplateType01.TEMPLATE_API_CHINESE_NAME_NAME, classChineseName);
            classInfoMap.put(TemplateType01.TEMPLATE_CLASS_NAME_PREFIX_NAME, aaaclassNamePrefix);

            if (i == 0) {
                classInfoMap.put(TemplateType01.TEMPLATE_ACTION_CLASS_NAME_PREFIX_NAME, classNamePrefix);
            }

            //      读取接口字段文件
            String templateFilePath = TemplateConstant.TEMPLATE_FILE_PATH;
            String csvConfigFileName = methodName + TemplateConstant.TEMPLATE_CSV_FILE_SUFFEX;
            File templateActionConfigFile = new File(templateFilePath, csvConfigFileName);

            File apiSource = templateActionConfigFile;
            Scanner bodyInput = new Scanner(apiSource, SystemConstant.DEFAULT_FILE_CHARSETNAME);

            StringBuilder reqFieldListTemplate = new StringBuilder();

            while (bodyInput.hasNext()) {
                String str = bodyInput.nextLine();

                StringBuilder fieldTemplateSb1 = new StringBuilder(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_01).append(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_02).append(TemplateType01.TYPE01_MESSAGE_FIELD_NAME_01);
                String[] strArr = str.split(SystemConstant.DEFAULT_CSV_SPLITY_REGEX);
                if (strArr.length == 0) {
                    continue;
                } else if (-1 != str.indexOf("^RES$")) {
                    break;
                }

                StringBuilderUtil.replaceAll(fieldTemplateSb1, TemplateType01.TEMPLATE_FIELD_TYPE_NAME,  Template01Util.chageFieldTypeValue(strArr[1]));
                StringBuilderUtil.replaceAll(fieldTemplateSb1, TemplateType01.TEMPLATE_FIELD_NAME_NAME, upperInitialName(changeApiNameToCodeName(strArr[0], 0), false));
                StringBuilderUtil.replaceAll(fieldTemplateSb1, TemplateType01.TEMPLATE_ALIAS_FIELD_NAME_NAME, upperInitialName(changeApiNameToCodeName(strArr[0], 0), false));
                StringBuilderUtil.replaceAll(fieldTemplateSb1, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, strArr[4]);
                StringBuilderUtil.replaceAll(fieldTemplateSb1, TemplateType01.TEMPLATE_FIELD_REQUIRE_TYPE_NAME, Template01Util.chageRequireValue(strArr[2]));

                reqFieldListTemplate.append(fieldTemplateSb1).append("\n");
            }

            StringBuilder resFieldListTemplate = new StringBuilder();

            while (bodyInput.hasNext()) {
                String str = bodyInput.nextLine();

                StringBuilder fieldTemplateSb2 = new StringBuilder(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_01).append(TemplateType01.TYPE01_MESSAGE_FIELD_SWAGGER_02).append(TemplateType01.TYPE01_MESSAGE_FIELD_NAME_01);
                String[] strArr = str.split(SystemConstant.DEFAULT_CSV_SPLITY_REGEX);
                if (strArr.length == 0) {
                    continue;
                }

                StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_TYPE_NAME, Template01Util.chageFieldTypeValue(strArr[1]));
                StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_NAME_NAME, upperInitialName(changeApiNameToCodeName(strArr[0], 0), false));
                StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_ALIAS_FIELD_NAME_NAME, upperInitialName(changeApiNameToCodeName(strArr[0], 0), false));
                StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_NOTE_NAME, strArr[4]);
                StringBuilderUtil.replaceAll(fieldTemplateSb2, TemplateType01.TEMPLATE_FIELD_REQUIRE_TYPE_NAME, Template01Util.chageRequireValue(strArr[2]));

                resFieldListTemplate.append(fieldTemplateSb2).append("\n");
            }
            bodyInput.close();

            reqTemplate = new ReqTemplate();
            classInfoMap.put("reqBodyFieldListTemplate", reqFieldListTemplate.toString());

            resTemplate = new ResTemplate();
            classInfoMap.put("resBodyFieldListTemplate", resFieldListTemplate.toString());

            //TODO service action de method
//            StringBuilder actionFieldTemplateSb = new StringBuilder(TemplateType01.TYPE01_ACTION_FIELD_NAME_01).append(TemplateType01.TYPE01_ACTION_FIELD_NAME_02);

            classInfoMap.putAll(reqTemplate.initTemplate(classInfoMap, creater));
            classInfoMap.putAll(resTemplate.initTemplate(classInfoMap, creater));

            creater.addCreateFile(reqTemplate);
            creater.addCreateFile(resTemplate);

            //IService method
            StringBuilder iServiceMethodTemplate = new StringBuilder(TemplateType01.TYPE01_SERVICE_INTERFACE_METHOD_NAME);
            StringBuilderUtil.replaceAll(iServiceMethodTemplate, TemplateType01.TEMPLATE_ACTION_METHOD_NAME_NAME, actionMechodName);

            //service method
            StringBuilder serviceMethodTemplate = new StringBuilder(TemplateType01.TYPE01_SERVICE_METHOD_NAME_01).append(TemplateType01.TYPE01_SERVICE_METHOD_NAME_02).append(TemplateType01.TYPE01_SERVICE_METHOD_NAME_03);
            StringBuilderUtil.replaceAll(serviceMethodTemplate, TemplateType01.TEMPLATE_SERVICE_CLASS_NAME_NAME, classInfoMap.get(TemplateType01.TEMPLATE_SERVICE_CLASS_NAME_NAME));
            StringBuilderUtil.replaceAll(serviceMethodTemplate, TemplateType01.TEMPLATE_CONFIG_DESC_FIELD_NAME_NAME, "DESC_"+methodName);
            StringBuilderUtil.replaceAll(serviceMethodTemplate, TemplateType01.TEMPLATE_ACTION_METHOD_NAME_NAME, actionMechodName);

            //action method
            StringBuilder actionMethodTemplate = new StringBuilder(TemplateType01.TYPE01_ACTION_METHOD_SWAGGER_01).append(TemplateType01.TYPE01_ACTION_METHOD_SWAGGER_02).append(TemplateType01.TYPE01_ACTION_METHOD_NAME_01).append(TemplateType01.TYPE01_ACTION_METHOD_NAME_02).append(TemplateType01.TYPE01_ACTION_METHOD_NAME_03);
            StringBuilderUtil.replaceAll(actionMethodTemplate, TemplateType01.TEMPLATE_API_FIELD_NOTE_NAME, fieldNoteList.get(i));
            StringBuilderUtil.replaceAll(actionMethodTemplate, TemplateType01.TEMPLATE_SERVICE_CLASS_CHINESE_NAME_NAME, classChineseName+"服务");
            StringBuilderUtil.replaceAll(actionMethodTemplate, TemplateType01.TEMPLATE_CONFIG_FIELD_VALUE_NAME, "API_"+methodName);
            StringBuilderUtil.replaceAll(actionMethodTemplate, TemplateType01.TEMPLATE_CONFIG_DESC_FIELD_NAME_NAME, "DESC_"+methodName);
            StringBuilderUtil.replaceAll(actionMethodTemplate, TemplateType01.TEMPLATE_ACTION_METHOD_NAME_NAME, actionMechodName);

            iServiceMethodListTemplateSb.append(iServiceMethodTemplate).append("\n");
            serviceMethodListTemplateSb.append(serviceMethodTemplate).append("\n");
            actionListTemplateSb.append(actionMethodTemplate).append("\n");
        }


        //service 信息构建
        serviceInterfaceTemplate = new ServiceInterfaceTemplate();
        serviceInterfaceTemplate.setMethodListTemplate(iServiceMethodListTemplateSb.toString());
        classInfoMap.put("serviceMethodListTemplate", serviceMethodListTemplateSb.toString());
        classInfoMap.putAll(serviceInterfaceTemplate.initTemplate(classInfoMap, creater));
        creater.addCreateFile(serviceInterfaceTemplate);

        //action 信息构建
        // package
        StringBuilder packagePathTemplateSb = new StringBuilder();
        packagePathTemplateSb.append(TemplateType01.TYPE01_ACTION_PACKAGE_PATH_SUFFIX);
        //class
        StringBuilder classNameTemplateSb = new StringBuilder();
        classNameTemplateSb.append(TemplateType01.TYPE01_ACTION_CLASS_NAME_SWAGGER).append(TemplateType01.TYPE01_ACTION_CLASS_NAME_01).append(TemplateType01.TYPE01_ACTION_CLASS_NAME_02);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_NAME, className);
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_NAME_PREFIX_NAME, classNamePrefix.toUpperCase());
        StringBuilderUtil.replaceAll(classNameTemplateSb, TemplateType01.TEMPLATE_CLASS_CHINESS_NAME_NAME, classChineseName);

        //field
        StringBuilder actionFieldTemplate = new StringBuilder(TemplateType01.TYPE01_ACTION_FIELD_NAME_01).append(TemplateType01.TYPE01_ACTION_FIELD_NAME_02);
        StringBuilderUtil.replaceAll(actionFieldTemplate, TemplateType01.TEMPLATE_CLASS_NAME_PREFIX_NAME,classNamePrefix);
//        StringBuilderUtil.replaceAll(actionFieldTemplate, TemplateType01.TEMPLATE_SERVICE_FIELD_CLASS_NAME_NAME, classInfoMap.getStudentById(TemplateType01.TEMPLATE_SERVICE_FIELD_CLASS_NAME_NAME));
        fieldListTemplateSb.append(actionFieldTemplate);

        //       替换模板中的元素
        classInfoMap.forEach(
                (k, y) -> {
                    StringBuilderUtil.replaceAll(packagePathTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(classNameTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(fieldListTemplateSb, k, y);
                    StringBuilderUtil.replaceAll(actionListTemplateSb, k, y);
                }
        );

        packagePathTemplate = packagePathTemplateSb.toString();
        classNameTemplate = classNameTemplateSb.toString();
        fieldListTemplate = fieldListTemplateSb.toString();
        methodListTemplate = actionListTemplateSb.toString();

    }


    /**
     * AGT_UPDATE_AGENT_STATE -> agtUpdateAgentState
     * 根据api名字获取类名
     *
     * @param inputAPIName
     */
    private static String changeApiNameToCodeName(String inputAPIName, int passCount) {
        inputAPIName = inputAPIName.toLowerCase();
        String[] nameArr = inputAPIName.split("_");
        String outAPIName = "";
        for (int i = 0; i < nameArr.length; i++) {
            if (i < passCount) continue;
            outAPIName = outAPIName + upperInitialName(nameArr[i], true);
        }
//        log.info("初始化java类名！[{}]", outAPIName);
        return outAPIName;
    }

    /**
     * agt -> Agt
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String upperInitialName(String name, Boolean flag) {
        char[] cs = name.toCharArray();
//        大写
        if (flag) {
            cs[0] -= 32;
        } else {
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }
}
