package com.qf.dao;

import com.qf.bean.Exam;
import com.qf.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //查询学生信息列表
    public List<Student> findall(Map map);

    //根据考试id查询考试成绩
    public List<Student> findscore(Map map);

    //修改成绩
    public int updatescore(Map map);

}