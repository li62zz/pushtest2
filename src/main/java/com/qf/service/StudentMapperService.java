package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface StudentMapperService {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //全查
    public PageInfo<Student> findall(int index, int size,String stuname,String stuno,int stusex);

    //查询考试成绩
    public PageInfo<Student> findscore(int index,int size,int examid,String stuName);

    //修改成绩
    public int updatescore(int examid,int studentid,int score);
}
