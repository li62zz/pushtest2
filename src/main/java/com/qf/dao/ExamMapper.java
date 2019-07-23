package com.qf.dao;

import com.qf.bean.Exam;

import java.util.List;
import java.util.Map;

public interface ExamMapper {
    //根据主键查询考试科目
    public Exam findbyid(int examid);

    //全查
    List<Exam> findall(Map map);

    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}