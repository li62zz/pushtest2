package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.UserTb;

import java.util.List;

public interface UserTbMapperService {

    UserTb login(String username, String password);
    boolean checkname(String name);
    UserTb updateusers(UserTb userTb);

    //查询全部用户和角色信息
    PageInfo<UserTb> findall(int index,int size);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}