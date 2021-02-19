package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.dao.SysDictDao;
import com.example.springBootDemo.entity.SysDictPo;
import com.example.springBootDemo.service.SysDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 字典表(SysDict)表服务实现类
 *
 * @author xiaoye
 * @since 2021-01-29 18:51:53
 */
@Slf4j
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictPo> implements SysDictService {

}