package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Student;
import com.qf.dao.StudentMapper;
import com.qf.service.StudentMapperService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentMapperServiceImpl implements StudentMapperService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer studentid) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentid) {
        return null;
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Student record) {
        int i=studentMapper.updateByPrimaryKeySelective(record);
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }

    //全查
    @Override
    public PageInfo<Student> findall(int index, int size,String stuname,String stuno,int stusex) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("sname",stuname);
        map.put("sno",stuno);
        map.put("sex",stusex);
        List<Student> students=studentMapper.findall(map);
        PageInfo<Student> pageInfo=new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    @Transactional
    public int updatescore(int examid, int studentid, int score) {
        Map map=new HashMap();
        System.out.println("service+++++++++++++++++examid"+examid);
        System.out.println("service+++++++++++++++++studentid"+studentid);
        System.out.println("service+++++++++++++++++score"+score);
        map.put("eid",examid);
        map.put("sid",studentid);
        map.put("sco",score);
        return studentMapper.updatescore(map);
    }

    @Override
    public PageInfo<Student> findscore(int index, int size,int examid,String stuName) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("examid",examid);
        map.put("stuname",stuName);

        List<Student> list = studentMapper.findscore(map);
        PageInfo<Student> pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
