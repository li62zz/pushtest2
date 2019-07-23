package com.qf.dao;

import com.qf.bean.Score;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer middleid);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer middleid);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}