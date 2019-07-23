package com.qf.dao;

import com.qf.bean.Orderdetail;

public interface OrderdetailMapper {
    int deleteByPrimaryKey(String detailid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(String detailid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}