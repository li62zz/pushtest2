package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.UserTb;
import com.qf.dao.UserTbMapper;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserTbMapperServiceImpl implements UserTbMapperService {

    @Resource
    private UserTbMapper userTbMapper;

    /**
     * 登录
     */
    @Override
    @Transactional
    public UserTb login(String username, String password) {
        //根据用户名查询信息
        UserTb userTb=userTbMapper.login(username);
        //验证密码
        if(userTb!=null&&password.equals(userTb.getUserPs())){
            //修改登录次数
            int count=userTb.getLogincount()+1;
            //调取修改方法
            userTb.setLogincount(count);
            userTbMapper.updateByPrimaryKeySelective(userTb);
            return userTb;
        }
        return null;
    }

    /**
     *判读用户名是否存在
     */
    @Override
    public boolean checkname(String name) {
        String checkname=userTbMapper.checkname(name);
        if(checkname!=null){
            return true;
        }
        return false;
    }

    /**
     * 更新用户信息
     */
    @Override
    @Transactional
    public UserTb updateusers(UserTb userTb) {
        int i=userTbMapper.updateByPrimaryKeySelective(userTb);
        if(i>0){
            UserTb userTb1=userTbMapper.login(userTb.getUserName());
            return userTb1;
        }
        return null;
    }

    @Override
    public PageInfo<UserTb> findall( int index, int size) {
        PageHelper.startPage(index,size);
        List<UserTb> userTbs = userTbMapper.findall();
        PageInfo pageInfo=new PageInfo(userTbs);
        return pageInfo;
    }

    /**
     * 用户管理:全查分页 模糊查
     */


    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(UserTb record) {
        return 0;
    }

    @Override
    public int insertSelective(UserTb record) {
        return 0;
    }

    @Override
    public UserTb selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserTb record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserTb record) {
        return 0;
    }
}
