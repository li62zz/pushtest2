package com.qf.service.impl;

import com.qf.bean.Major;
import com.qf.dao.MajorMapper;
import com.qf.service.MajorMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MajorMapperServiceImpl implements MajorMapperService {

    @Resource
    private MajorMapper majorMapper;
    //根据院系id查询专业
    @Override
    public List<Major> findbydeptid(int deptid) {
        return majorMapper.findbydeptid(deptid);
    }

    @Override
    public int deleteByPrimaryKey(Integer majorid) {
        return 0;
    }

    @Override
    public int insert(Major record) {
        return 0;
    }

    @Override
    public int insertSelective(Major record) {
        return 0;
    }

    @Override
    public Major selectByPrimaryKey(Integer majorid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Major record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Major record) {
        return 0;
    }
}
