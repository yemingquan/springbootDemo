package com.example.springBootDemo.model.create;

import com.example.springBootDemo.config.parameters.constant.TemplateConstant;
import com.example.springBootDemo.config.parameters.constant.TemplateType01;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @所属模块 自动生成
 * @描述 文件创建者
 * @创建人 xiaoYe
 * @创建时间 2020/5/16 9:23
 * @备注
 */
@Data
public class FileCreater {
    List<BaseClassInfo> classList;
    /**
     * 用于存入公共classInfoMap
     */
    private Map classInfoMap;


    {
        this.classList = new ArrayList<>();
        classInfoMap = new HashMap();
        classInfoMap.put(TemplateConstant.TEMPLATE_PROJECT_PATH_NAME, TemplateConstant.TEMPLATE_PROJECT_BATH_PATH_VALUE);
    }

    /**
     * 公共类创建后添加到list
     * 该方法创建文件
     *
     * @param c
     */
    public void createPubFile(BaseClassInfo c) throws Exception {
        if (c.createFlag) return;
        if (!c.publicFlag) return;
        Map map = c.initTemplate(classInfoMap, this);
        classInfoMap.putAll(map);
        classList.add(c);
    }

    /**
     * 普通文件创建（由Action进行入口创建）
     * 该方法不创建文件
     *
     * @param c
     */
    public void addCreateFile(BaseClassInfo c) throws Exception{
        if (c.publicFlag) return;
        if (c.createFlag) return;
        if (TemplateType01.TYPE01_ACTION_CLASS_NAME_SUFFEX.equals(c.classNameSuffex)) {
            c.initTemplate(classInfoMap, this);
        }
        classList.add(c);
    }

    /**
     * 创建文件
     */
    public void create() {
        classList.stream().filter(po -> !po.isCreateFlag()).forEach(BaseClassInfo::createFile);
    }
}
