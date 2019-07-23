package com.qf.dao;

import com.qf.bean.UserTb;

import java.util.List;

public interface UserTbMapper {

    UserTb login(String name);
    String checkname(String name);
    //查询全部用户和角色信息
    List<UserTb> findall();

    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}