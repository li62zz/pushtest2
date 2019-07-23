package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;

import java.util.List;

public interface ClassesMapperService {
    List<Classes> findbimid(int majorid);

    //班级管理
    public PageInfo<Classes> findall(int index, int size, String classname);

    //根据专业id查询老师
    public List<String> findteacher(int mid);

    //班级审核
    public PageInfo<Classes> selectaudit(int index,int size,String classnum,String classname,int userid);

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}