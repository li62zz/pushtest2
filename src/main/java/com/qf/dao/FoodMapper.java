package com.qf.dao;

import com.qf.bean.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(String foodid);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(String foodid);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}