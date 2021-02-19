package com.example.springBootDemo.service.create.impl;

import com.example.springBootDemo.config.parameters.constant.SystemConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateConstant;
import com.example.springBootDemo.model.create.BaseClassInfo;
import com.example.springBootDemo.model.create.FileCreater;
import com.example.springBootDemo.model.create.type01.ActionTemplate;
import com.example.springBootDemo.model.create.type01.ConfigTemplate;
import com.example.springBootDemo.model.create.type01.ReqHeadTemplate;
import com.example.springBootDemo.model.create.type01.ResHeadTemplate;
import com.example.springBootDemo.service.create.ICreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/5/16 10:37
 * @备注
 */
@Slf4j
@Service
public class CreateService implements ICreateService {


    @Override
    public void createFile() throws Exception {
//      1.数据初始化
//        Map infoMap = new HashMap<String, String>();
//        Map<String, String[]> apiMap = new HashMap<String, String[]>();
        FileCreater creater = new FileCreater();
//      初始化常量配置类
        ConfigTemplate configTemplate = new ConfigTemplate();
        configTemplate.setClassNamePrefix("Api");
        List<String> fieldNameList = new ArrayList<>();
        List<String> fieldValueList = new ArrayList<>();
        List<String> fieldNoteList = new ArrayList<>();
        List<String> actionNameList = new ArrayList<>();
//      初始化接口类
        Map<String, BaseClassInfo> actionClassMap = new HashMap<>();

//      读取初始信息配置文件
        String templateActionConfigFilePath = TemplateConstant.TEMPLATE_FILE_PATH;
        String templateActionConfigFileName = TemplateConstant.TEMPLATE_ACTION_CONFIG_FILE_NAME;
        File templateActionConfigFile = new File(templateActionConfigFilePath, templateActionConfigFileName);

        File apiSource = templateActionConfigFile;
        Scanner apiFile = new Scanner(apiSource, SystemConstant.DEFAULT_FILE_CHARSETNAME);
        while (apiFile.hasNext()) {
//          分离接口配置信息
            String str = apiFile.nextLine();
            String[] apiStr = str.split(SystemConstant.DEFAULT_CSV_SPLITY_REGEX);
//            boolean apiCreateFlag = Boolean.getBoolean(apiStr[3]);
            boolean apiCreateFlag = "n".equals(apiStr[3]);

//          AGT_STOP_PAUMENT action类名_功能类型（dropDownList、select、upd、add、del、getDetail）_功能名
            String apiInConfig = apiStr[0];
            String apiOutConfig = apiStr[1];
            String apiChineseName = apiStr[2];
            String actionClassChineseName = apiStr[4];

            if (apiCreateFlag) {
                log.info("跳过[{}]的生成！", apiChineseName);
                continue;
            }

//          集合读取的信息
            fieldNameList.add(apiInConfig);
            fieldValueList.add(apiOutConfig);
            fieldNoteList.add(apiChineseName);
//          接口配置类刷新读取的信息
            flushActionClassMap(actionNameList, actionClassMap, apiInConfig, apiOutConfig, apiChineseName, actionClassChineseName);
        }
        apiFile.close();

//      添加公共文件
        configTemplate.setFieldNameList(fieldNameList);
        configTemplate.setFieldValueList(fieldValueList);
        configTemplate.setFieldNoteList(fieldNoteList);
        creater.createPubFile(configTemplate);

        ReqHeadTemplate reqHeadTemplate = new ReqHeadTemplate();
        reqHeadTemplate.setClassNamePrefix("ReqHead");
        creater.createPubFile(reqHeadTemplate);

        ResHeadTemplate resHeadTemplate = new ResHeadTemplate();
        resHeadTemplate.setClassNamePrefix("ResHead");
        creater.createPubFile(resHeadTemplate);

        actionClassMap.forEach((k, v) -> {
            try {
                creater.addCreateFile(v);
            } catch (Exception e) {
                log.error("创建action异常[{}]", v.getClassChineseName());
                e.printStackTrace();
            }
        });

        // 创建文件
        creater.create();
    }

    /**
     * 刷新actionClassMap的状态
     *
     * @param actionNameList
     * @param actionClassMap
     * @param apiInConfig
     * @param actionClassChineseName
     */
    private void flushActionClassMap(List<String> actionNameList, Map<String, BaseClassInfo> actionClassMap, String apiInConfig, String apiOutConfig, String apiChineseName, String actionClassChineseName) {
//      action新增或追加方法的处理
        String actionName = apiInConfig.substring(0, apiInConfig.indexOf("_"));
        String classNamePrefix = upperInitialName(actionName.toLowerCase(), true);

        if (actionNameList.contains(actionName)) {
//          追加action方法
            BaseClassInfo temp = actionClassMap.get(actionName);

            List<String> methodlist = temp.getMethodList();
            methodlist.add(apiInConfig);
            List<String> fieldNameList = temp.getFieldNameList();
            fieldNameList.add(apiOutConfig);
            List<String> fieldNoteList = temp.getFieldNoteList();
            fieldNoteList.add(apiChineseName);

            actionNameList.add(actionName);
        } else {
//          新增action类
            ActionTemplate temp = new ActionTemplate();
            temp.setClassNamePrefix(classNamePrefix);
            temp.setClassChineseName(actionClassChineseName);

            List<String> methodlist = temp.getMethodList();
            methodlist.add(apiInConfig);
            List<String> fieldNameList = temp.getFieldNameList();
            fieldNameList.add(apiOutConfig);
            List<String> fieldNoteList = temp.getFieldNoteList();
            fieldNoteList.add(apiChineseName);

            actionNameList.add(actionName);
            actionClassMap.put(actionName, temp);
        }
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
