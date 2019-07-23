package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.dao.ClassesMapper;
import com.qf.service.ClassesMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassesMapperServiceImpl implements ClassesMapperService {

    @Resource
    private ClassesMapper classesMapper;
    @Override
    public List<Classes> findbimid(int majorid) {
        return classesMapper.findbimid(majorid);
    }

    //查询所有班级
    @Override
    public PageInfo<Classes> findall(int index, int size, String classname) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("classname",classname);
        List<Classes> classesList = classesMapper.findall(map);
        PageInfo<Classes> pageInfo=new PageInfo(classesList);
        return pageInfo;
    }

    //根据专业id查询老师名字
    @Override
    public List<String> findteacher(int mid) {
        List<String> list = classesMapper.findteacher(mid);
        return classesMapper.findteacher(mid);
    }

    @Override
    //班级审核
    public PageInfo<Classes> selectaudit(int index, int size, String classnum, String name, int userid) {
        //1.指定分页操作
        PageHelper.startPage(index,size);
        //2.调取查询方法
        Map map=new HashMap();
        map.put("classname",name);
        map.put("classno",classnum);
        map.put("userid",userid);
        List<Classes> list=classesMapper.selectaudit(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer classid) {
        return 0;
    }

    @Override
    public int insert(Classes record) {
        return 0;
    }

    @Override
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    @Override
    public Classes selectByPrimaryKey(Integer classid) {
        return classesMapper.selectByPrimaryKey(classid);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return 0;
    }
}
