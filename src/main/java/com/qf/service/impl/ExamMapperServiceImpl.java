package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Exam;
import com.qf.bean.Major;
import com.qf.dao.ExamMapper;
import com.qf.service.ExamMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamMapperServiceImpl implements ExamMapperService {

    @Resource
    private ExamMapper examMapper;

   //考试查询 分页 模糊查
    @Override
    public PageInfo<Exam> findexam(int index, int size, String name) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("subject",name);
        List<Exam> examList = examMapper.findall(map);
        PageInfo<Exam> pageInfo=new PageInfo(examList);
        return pageInfo;
    }

    //主键查询
    public Exam findbyid(int examid){
       return examMapper.findbyid(examid);
    }

    //查询成绩


    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer examid) {
        return examMapper.deleteByPrimaryKey(examid);
    }

    @Override
    public int insert(Exam record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Exam record) {
        return examMapper.insertSelective(record);
    }

    @Override
    public Exam selectByPrimaryKey(Integer examid) {
        return null;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Exam record) {
        return examMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Exam record) {
        return 0;
    }
}
