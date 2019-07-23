package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Exam;

public interface ExamMapperService {
    //全查和分页
    public PageInfo<Exam> findexam(int index,int size,String name);

    //主键查询
    public Exam findbyid(int examid);


    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}