package com.example.springBootDemo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * @所属模块
 * @描述 自动生成
 * @创建人 xiaoYe
 * @创建时间 2020/4/11 13:54
 * @备注
 */
@Slf4j
public class GenerationUtil {

    public static void main(String[] args) throws Exception {
        log.info("hello generation!");

        String basePath = "E:\\develop\\workSpace\\idea\\springBootDemo\\src\\main\\resources\\template\\";
        String packageBasePath = "com.posp.oos.web.srv";
        log.info("模板文件位置[{}]", basePath);

//       生成apiMap
        Map<String, String[]> apiMap = getAPIMap(basePath);

//      循环生成文件
        for (String key : apiMap.keySet()) {
            String[] apiStr = apiMap.get(key);
//          AGT_UPDATE_AGENT
            String apiName = apiStr[0];
//          报文前缀
            String messageNamePrefix = getGenMessageNameByAPIName(apiName);
//          服务类前缀
            String FileNamePrefix = upperInitialName(apiName.split("_")[0].toLowerCase(), true);
            Map<String, String> classNameMap = initFileParam(messageNamePrefix, FileNamePrefix);
//          AGT_003
            String oldApiName = apiStr[1];
//          修改代理商
            String apiDescription = apiStr[2];
//          y
            String creatFlag = apiStr[3];
            if ("n".equals(creatFlag)) continue;

//         Action描述
            String actionDescription = apiStr[4];

//          生成请求和响应报文
            Map<String, Map> apiModelPropertyMap = getMessageBodyMap(basePath, oldApiName);

            String messageType = "req";

            Map<String, String> reqMap = getMessageMap(classNameMap, apiDescription, messageType, packageBasePath);
            createMessageFile(classNameMap, basePath, reqMap);
            Map<String, String[]> modelPropertyMap = apiModelPropertyMap.get("req");
            createMessageBodyFile(basePath, classNameMap, reqMap, modelPropertyMap);

            messageType = "res";
            Map<String, String> resMap = getMessageMap(classNameMap, apiDescription, messageType, packageBasePath);
            createMessageFile(classNameMap, basePath, resMap);
            modelPropertyMap = apiModelPropertyMap.get("res");
            createMessageBodyFile(basePath, classNameMap, resMap, modelPropertyMap);

//          生成Action
            Map<String, String> actionMap = getActionMap(packageBasePath, classNameMap, actionDescription);
            Map<String, String> actionPropertyMap = getActionPropertyMap(apiName, messageNamePrefix, classNameMap, apiDescription);
            creatActionFile(basePath, actionPropertyMap, modelPropertyMap, actionMap);


        }


    }

    private static Map<String, String> getActionPropertyMap(String apiName, String messageNamePrefix, Map<String, String> classNameMap, String apiDescription) {
        Map<String, String> actionPropertyMap = new HashMap<>();
        actionPropertyMap.put("^apiDescription$", apiDescription);
        actionPropertyMap.put("^reqName$", classNameMap.get("reqName"));
        actionPropertyMap.put("^routeName$", apiName);
        actionPropertyMap.put("^resName$", classNameMap.get("resName"));
        actionPropertyMap.put("^classServiceName$", upperInitialName(classNameMap.get("serviceName"), false));
        actionPropertyMap.put("^actionMethodName$", upperInitialName(messageNamePrefix, false));
        return actionPropertyMap;
    }

    private static void creatActionFile(String basePath, Map<String, String> actionPropertyMap, Map<String, String[]> modelPropertyMap, Map<String, String> actionMap) throws IOException {
        //      初始化流
        String templateFilePath = basePath + "templateFile\\";
        String targetFilePath = basePath + "result\\";
        File actionSource = new File(templateFilePath + "ApiActionFile");
        File actionPropertySource = new File(templateFilePath + "ApiActionPropertyConfig");
        File actionTarget = null;
        File actionPropertyTarget = null;
//          临时文件夹
        String tempPath = targetFilePath + "\\controller\\temp\\" + actionMap.get("^tempPath$").replace(".", "") + "\\";
        File tempPathFile = new File(tempPath);
        filePathCheck(tempPathFile);
        String className = actionMap.get("^className$");
        actionTarget = new File(tempPath + className + ".java");
        actionPropertyTarget = new File(tempPath + "\\part\\" + className);
        filePathCheck(new File(actionPropertyTarget.getParent()));
//      拼接到文件末尾
        FileWriter actionPropertyAppendWrite = new FileWriter(actionPropertyTarget, true);

        Scanner actionInput = new Scanner(actionSource);
        Scanner actionPropertyInput = new Scanner(actionPropertySource);
        PrintWriter actionWriter = new PrintWriter(actionTarget);
        PrintWriter actionPropertyAppendWriter = new PrintWriter(actionPropertyAppendWrite);

//      报文体生成
//      前部
        StringBuilder sbTemp = new StringBuilder();
        while (actionInput.hasNext()) {
            sbTemp.append(actionInput.nextLine() + "\n");
        }
        //替换
        for (String key : actionMap.keySet()) {
            String value = actionMap.get(key);
            replaceAll(sbTemp, key, value);
        }
        log.info(sbTemp.toString());
        actionWriter.write(sbTemp + "}\n");

        actionInput.close();
        actionWriter.close();
        log.info("[{}]生成完毕！", className);

//      后部-片段
        StringBuilder sbPartTemp = new StringBuilder();
        while (actionPropertyInput.hasNext()) {
            sbPartTemp.append(actionPropertyInput.nextLine() + "\n");
        }
        //替换
        for (String key : actionPropertyMap.keySet()) {
            String value = actionPropertyMap.get(key);
            replaceAll(sbPartTemp, key, value);
        }
        log.info(sbPartTemp.toString());
        actionPropertyAppendWriter.write(sbPartTemp.toString() + "\n");

        actionPropertyInput.close();
        actionPropertyAppendWriter.close();
        log.info("[{}]生成完毕！", className);
    }

    private static void filePathCheck(File tempPathFile) {
        if (!tempPathFile.exists()) {
            tempPathFile.mkdirs();
        }
    }

    private static Map<String, String> getActionMap(String packageBasePath, Map<String, String> classNameMap, String actionDescription) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put("^basePath$", packageBasePath);
        actionMap.put("^tempPath$", ".old");
        actionMap.put("^serviceName$", classNameMap.get("serviceName"));
        actionMap.put("^actionDescription$", actionDescription);
        actionMap.put("^className$", classNameMap.get("actionName"));
        actionMap.put("^classServiceName$", upperInitialName(classNameMap.get("serviceName"), false));
        return actionMap;
    }

    /**
     * 生成报文体
     *
     * @param basePath
     * @param classNameMap
     * @param messageMap
     * @param modelPropertyMap
     * @throws FileNotFoundException
     */
    private static void createMessageBodyFile(String basePath, Map<String, String> classNameMap, Map<String, String> messageMap, Map<String, String[]> modelPropertyMap) throws FileNotFoundException {
        //      初始化流
        String templateFilePath = basePath + "templateFile\\";
        String targetFilePath = basePath + "result\\";
        File bodySource = new File(templateFilePath + "MessageBodyFile");
        File propertySource = new File(templateFilePath + "ApiModelPropertyConfig");
        File bodyTarget = null;
//      临时文件夹
        String messageType = messageMap.get("\\^messageType\\$");
        String tempPath = targetFilePath + messageType + "//" + messageMap.get("\\^tempPath\\$").replace(".", "") + "\\body\\";
        File tempPathFile = new File(tempPath);
        filePathCheck(tempPathFile);
        String className = classNameMap.get(messageType + "BodyName");
        messageMap.put("\\^className\\$", className);
        bodyTarget = new File(tempPath + className + ".java");

        Scanner bodyInput = new Scanner(bodySource);
        Scanner propertyInput = new Scanner(propertySource);
        PrintWriter writer = new PrintWriter(bodyTarget);

//      报文体生成
//      前部
        while (bodyInput.hasNext()) {
            String str = bodyInput.nextLine();
            //替换
            if (str.contains("$")) {
                for (String key : messageMap.keySet()) {
                    String value = messageMap.get(key);
                    str = str.replaceAll(key, value);
                }
            }
            log.info(str);
            writer.write(str + "\n");
        }
        bodyInput.close();
//      后部
        StringBuilder sb = new StringBuilder();
        while (propertyInput.hasNext()) {
            sb.append(propertyInput.nextLine() + "\n");
        }
        propertyInput.close();

        //替换
        Map<String, String[]> messageBodyRowMap = new HashMap<String, String[]>();
        for (String key : modelPropertyMap.keySet()) {
            StringBuilder sbTemp = new StringBuilder(sb);
            String[] str = modelPropertyMap.get(key);
            if (str[0].contains("rows:rows")) {
                String bodyRowsName = classNameMap.get(messageType + "BodyRowsName");
                String typeProperty = str[2];
                sbTemp = getRowPropertyStringBuilder(bodyRowsName, templateFilePath, typeProperty);
            } else if (str[0].contains("rows:")) {
                str[0] = str[0].replace("rows:", "");
                messageBodyRowMap.put(str[0], str);
                continue;
            } else {
                getUsualPropertyStringBuilder(sbTemp, str);
            }

            writer.write(sbTemp + "\n");
            log.info(sbTemp.toString());
        }
        writer.write("}");
        writer.close();
        log.info("[{}]生成完毕！", className);

        //     生成row报文类
        if (!messageBodyRowMap.isEmpty()) {
            createRowBodyFile(classNameMap, messageMap, messageBodyRowMap, bodySource, tempPath, sb);
        }
    }

    /**
     * 生成bodyRow文件
     *
     * @param classNameMap
     * @param messageMap
     * @param modelPropertyMap
     * @param bodySource
     * @param tempPath
     * @param sb
     * @throws FileNotFoundException
     */
    private static void createRowBodyFile(Map<String, String> classNameMap, Map<String, String> messageMap, Map<String, String[]> modelPropertyMap, File bodySource, String tempPath, StringBuilder sb) throws FileNotFoundException {
        String messageType = messageMap.get("\\^messageType\\$");
        String className = classNameMap.get(messageType + "BodyRowsName");
        File bodyTarget = new File(tempPath + className + ".java");
        messageMap.put("\\^className\\$", className);

        Scanner bodyInput = new Scanner(bodySource);
        PrintWriter writer = new PrintWriter(bodyTarget);

        while (bodyInput.hasNext()) {
            String str = bodyInput.nextLine();
            //替换
            if (str.contains("$")) {
                for (String key : messageMap.keySet()) {
                    String value = messageMap.get(key);
                    str = str.replaceAll(key, value);
                }
            }
            log.info(str);
            writer.write(str + "\n");
        }
        bodyInput.close();

        for (String key : modelPropertyMap.keySet()) {
            StringBuilder sbTemp = new StringBuilder(sb);
            String[] str = modelPropertyMap.get(key);
            getUsualPropertyStringBuilder(sbTemp, str);

            writer.write(sbTemp + "\n");
            log.info(sbTemp.toString());
        }
        writer.write("}");
        writer.close();
        log.info("[{}]生成完毕！", className);
    }

    /**
     * 生成row属性
     *
     * @param bodyRowsName
     * @param templateFilePath
     * @param requireProperty
     * @return
     * @throws FileNotFoundException
     */
    private static StringBuilder getRowPropertyStringBuilder(String bodyRowsName, String templateFilePath, String requireProperty) throws FileNotFoundException {
        File rowPopertySource = new File(templateFilePath + "ApiModelRowPropertyConfig");
        Scanner rowPopertyInput = new Scanner(rowPopertySource);
        StringBuilder rowSb = new StringBuilder();
        while (rowPopertyInput.hasNext()) {
            rowSb.append(rowPopertyInput.nextLine() + "\n");
        }
        replaceAll(rowSb, "^bodyRowsName$", bodyRowsName);
        replaceAll(rowSb, "^requireProperty$", requireProperty);
        rowPopertyInput.close();
        return rowSb;
    }

    private static void getUsualPropertyStringBuilder(StringBuilder sb, String[] str) {
        Map<String, String> messageBodyMap = new HashMap<String, String>();
        messageBodyMap.put("^nameProperty$", str[0]);
        messageBodyMap.put("^typeProperty$", str[1]);
        messageBodyMap.put("^requireProperty$", str[2]);
        messageBodyMap.put("^exampleProperty$", str[3]);
        messageBodyMap.put("^noteProperty$", str[4]);
        for (String key : messageBodyMap.keySet()) {
            String value = messageBodyMap.get(key);
            replaceAll(sb, key, value);
        }
    }

    /**
     * @param classNameMap
     * @param basePath
     * @param messageMap
     * @throws FileNotFoundException
     */
    private static void createMessageFile(Map<String, String> classNameMap, String basePath, Map<String, String> messageMap) throws FileNotFoundException {
//      初始化流
        String templateFilePath = basePath + "templateFile\\";
        String targetFilePath = basePath + "result\\";
        File source = new File(templateFilePath + "MessageFile");
        File target = null;
//      临时文件夹
        String messageType = messageMap.get("\\^messageType\\$");
        String tempPath = targetFilePath + messageType + "//" + messageMap.get("\\^tempPath\\$").replace(".", "") + "\\";
        File tempPathFile = new File(tempPath);
        filePathCheck(tempPathFile);
        String className = classNameMap.get(messageType + "Name") + ".java";
        target = new File(tempPath + className);

        Scanner input = new Scanner(source);
        PrintWriter writer = new PrintWriter(target);

//      报文生成
        while (input.hasNext()) {
            String str = input.nextLine();
            //替换
            if (str.contains("$")) {
                for (String key : messageMap.keySet()) {
                    String value = messageMap.get(key);
                    str = str.replaceAll(key, value);
//                    log.info("key[{}]，value[{}]", key, value);
                }
            }
            log.info(str);
            writer.write(str + "\n");
        }
        writer.write("\n}");
        input.close();
        writer.close();
        log.info("[{}]生成完毕！", className);
    }

    /**
     * 获得报文体Map
     *
     * @param basePath
     * @param oldApiName
     * @return
     * @throws FileNotFoundException
     */
    private static Map<String, Map> getMessageBodyMap(String basePath, String oldApiName) throws FileNotFoundException {
        String propertyFilePath = basePath + "\\config\\message\\";
        Map<String, Map> apiModelPropertyMap = new HashMap<String, Map>();
        Map<String, String[]> reqModelPropertyMap = new HashMap<String, String[]>();
        Map<String, String[]> resModelPropertyMap = new HashMap<String, String[]>();
        apiModelPropertyMap.put("req", reqModelPropertyMap);
        apiModelPropertyMap.put("res", resModelPropertyMap);

        File apiModelPropertySource = new File(propertyFilePath + oldApiName + ".csv");
        Scanner apiModelPropertyInput = new Scanner(apiModelPropertySource, "GBK");
        log.info("_______装填reqBodyMap__________");
        inputBodyMap(reqModelPropertyMap, apiModelPropertyInput);
        log.info("_______装填resBodyMap__________");
        inputBodyMap(resModelPropertyMap, apiModelPropertyInput);
        apiModelPropertyInput.close();
        return apiModelPropertyMap;
    }

    /**
     * 输入数据到BodyMap中
     *
     * @param modelPropertyMap
     * @param apiModelPropertyInput
     */
    private static void inputBodyMap(Map<String, String[]> modelPropertyMap, Scanner apiModelPropertyInput) {
        while (apiModelPropertyInput.hasNext()) {
            String str = apiModelPropertyInput.nextLine();
            if (str.contains("^RES$")) {
                break;
            }
            String[] apiModelPropertyStr = str.split(",");
//          去除无效列
            if (apiModelPropertyStr.length == 0) continue;
//           数据处理
            formatApiModelProperty(apiModelPropertyStr);
            log.info("reqBodyMap[{}]", Arrays.toString(apiModelPropertyStr));
            modelPropertyMap.put(apiModelPropertyStr[0], apiModelPropertyStr);
        }
    }

    /**
     * 格式化输入到bodyMap的数据
     *
     * @param apiModelPropertyStr
     */
    private static void formatApiModelProperty(String[] apiModelPropertyStr) {
        //            必填项
        if ("非必须".equals(apiModelPropertyStr[2])) {
            apiModelPropertyStr[2] = "false";
        } else {
            apiModelPropertyStr[2] = "true";
        }
//          类型
        if ("number".equals(apiModelPropertyStr[1])) {
            List<String> arr = Arrays.asList(new String[]{"金额", "费率", "手续费"});
            arr.forEach(String -> {
                if (apiModelPropertyStr[1].contains(String)) {
                    apiModelPropertyStr[1] = "double";
                }
            });
            if (apiModelPropertyStr[1].contains("id")) {
                apiModelPropertyStr[1] = "long";
            } else {
                apiModelPropertyStr[1] = "int";
            }
        } else if ("string".equals(apiModelPropertyStr[1])) {
            apiModelPropertyStr[1] = "String";
        }
    }

    /**
     * 获得api信息
     *
     * @param basePath
     * @return
     * @throws FileNotFoundException
     */
    private static Map<String, String[]> getAPIMap(String basePath) throws FileNotFoundException {
        String configFile = basePath + "\\config\\API.csv";
        Map<String, String[]> apiConfigMap = new HashMap<String, String[]>();
        File apiSource = new File(configFile);
        Scanner apiInput = new Scanner(apiSource, "GBK");
        while (apiInput.hasNext()) {
            String str = apiInput.nextLine();
            String[] apiStr = str.split(",");
            apiConfigMap.put(apiStr[0], apiStr);
        }
        apiInput.close();
        return apiConfigMap;
    }

    /**
     * @param classNameMap
     * @param apiDescription
     * @param messageType
     * @param packageBasePath
     * @return
     */
    private static Map<String, String> getMessageMap(Map<String, String> classNameMap, String apiDescription, String messageType, String packageBasePath) {
        Map<String, String> messageMap = new HashMap<String, String>();
        messageMap.put("\\^basePath\\$", packageBasePath);
        messageMap.put("\\^apiDescription\\$", apiDescription);
        messageMap.put("\\^messageType\\$", messageType);
        messageMap.put("\\^tempPath\\$", ".old");
        if ("req".equals(messageType)) {
            messageMap.put("\\^messageTypeDescription\\$", "请求");
            messageMap.put("\\^reqBodyName\\$", classNameMap.get("reqBodyName"));
            messageMap.put("\\^className\\$", classNameMap.get("reqName"));
            messageMap.put("\\^classMessageType\\$", "Req");
        } else {
            messageMap.put("\\^messageTypeDescription\\$", "响应");
            messageMap.put("\\^reqBodyName\\$", classNameMap.get("resBodyName"));
            messageMap.put("\\^className\\$", classNameMap.get("resName"));
            messageMap.put("\\^classMessageType\\$", "Res");
        }
        return messageMap;
    }

    /**
     * 初始化文件参数名
     *
     * @param messageNamePrefix
     * @param FileNamePrefix
     * @return
     */
    private static Map<String, String> initFileParam(String messageNamePrefix, String FileNamePrefix) {
        String reqName = messageNamePrefix + "ReqVo";
        String reqBodyName = messageNamePrefix + "BodyReqVo";
        String reqBodyRowsName = messageNamePrefix + "RowsBodyReqVo";
        String resName = messageNamePrefix + "ResVo";
        String resBodyName = messageNamePrefix + "BodyResVo";
        String resBodyRowsName = messageNamePrefix + "RowsBodyReqVo";

        String actionName = FileNamePrefix + "MethodAnnotation";
        String serviceName = FileNamePrefix + "Service";
        String serviceImplName = FileNamePrefix + "ServiceImpl";

        Map<String, String> classNameMap = new HashMap<String, String>();
        classNameMap.put("reqName", reqName);
        classNameMap.put("reqBodyName", reqBodyName);
        classNameMap.put("reqBodyRowsName", reqBodyRowsName);
        classNameMap.put("resName", resName);
        classNameMap.put("resBodyName", resBodyName);
        classNameMap.put("resBodyRowsName", resBodyRowsName);
        classNameMap.put("actionName", actionName);
        classNameMap.put("serviceName", serviceName);
        classNameMap.put("serviceImplName", serviceImplName);

        log.info("注入初始文件名！");
        classNameMap.forEach((k, v) -> {
            log.info("文件名：{}:{}.java", k, v);
        });
        return classNameMap;
    }


    /**
     * 根据api名字获取类名
     *
     * @param inputAPIName
     */
    private static String getGenMessageNameByAPIName(String inputAPIName) {
        inputAPIName = inputAPIName.toLowerCase();
        String[] nameArr = inputAPIName.split("_");
        String outAPIName = "";
        for (int i = 0; i < nameArr.length; i++) {
            if (i == 0) continue;
            outAPIName = outAPIName + upperInitialName(nameArr[i], true);
        }
        log.info("初始化java类名！[{}]", outAPIName);
        return outAPIName;
    }

    /**
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

    /**
     * 实现StringBuilder的replaceAll
     *
     * @param stb
     * @param oldStr 被替换的字符串
     * @param newStr 替换oldStr
     * @return
     */
    public static StringBuilder replaceAll(StringBuilder stb, String oldStr, String newStr) {
        if (stb == null || oldStr == null || newStr == null || stb.length() == 0 || oldStr.length() == 0)
            return stb;
        int index = stb.indexOf(oldStr);
        if (index > -1 && !oldStr.equals(newStr)) {
            int lastIndex = 0;
            while (index > -1) {
                stb.replace(index, index + oldStr.length(), newStr);
                lastIndex = index + newStr.length();
                index = stb.indexOf(oldStr, lastIndex);
            }
        }
        return stb;
    }
}
