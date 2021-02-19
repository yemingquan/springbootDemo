package com.example.springBootDemo.util;

import com.example.springBootDemo.config.parameters.constant.TemplateType01;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/6/7 14:28
 * @备注
 */
public class Template01Util {

    /**
     * 封装导入信息
     *
     * @param className
     * @param packagePathTemplate
     * @return
     */
    public static String creatImportInfo(String className, String packagePathTemplate) {
        StringBuilder sb = new StringBuilder(TemplateType01.TYPE01_IMPORT + packagePathTemplate);
        StringBuilderUtil.replaceAll(sb, ";", "." + className + ";");
        return sb.toString();
    }

    /**
     * 改变必填项属性的值
     *
     * @param str
     * @return
     */
    public static String chageRequireValue(String str) {
        String checkValue = "非必须|false|NO|n";
        if (checkValue.contains(str)) {
            return "false";
        } else {
            return "true";
        }
    }

    public static String chageFieldTypeValue(String str) {
        String aa = "number";
        if (aa.contains(str)) {
            return "int";
        } else {
            return "String";
        }
    }
}
