package com.qf.dao;

import com.qf.bean.Foodtype;

public interface FoodtypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(Foodtype record);

    int insertSelective(Foodtype record);

    Foodtype selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(Foodtype record);

    int updateByPrimaryKey(Foodtype record);
}