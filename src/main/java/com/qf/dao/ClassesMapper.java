package com.qf.dao;

import com.qf.bean.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesMapper {
    //根据专业id查询班级
    public List<Classes> findbimid(int majorid);

    //查询所有班级
    public List<Classes> findall(Map map);

    //根据专业id查询老师列表
    public List<String> findteacher(int mid);

    //班级审核
    public List<Classes> selectaudit(Map map);

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}