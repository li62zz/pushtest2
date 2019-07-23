package com.qf.service.impl;

import com.qf.bean.Department;
import com.qf.dao.DepartmentMapper;
import com.qf.service.DepartmentMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentMapperServiceImpl implements DepartmentMapperService {

    @Resource
    DepartmentMapper departmentMapper;
    @Override
    public int deleteByPrimaryKey(Integer departid) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public Department selectByPrimaryKey(Integer departid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }

    @Override
    //查询所有院系信息
    public List<Department> findall() {
        return departmentMapper.findall();
    }
}
