package com.example.springBootDemo.dao;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/7/16 21:32
 * @备注
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.springBootDemo.model.Student2;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface StudentMapper extends BaseMapper<Student2> {
    @Select("selectUserList")
    List<Student2> selectUserList(Pagination page, String state);
}
