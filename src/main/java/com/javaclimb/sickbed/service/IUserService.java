package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.javaclimb.sickbed.entity.User;

import java.util.List;


/*
* 用户表增删查改service接口
* */
public interface IUserService extends IService<User> {
    //根据用户名查询用户对象

    public User queryUserByusername(User user);

    public IPage<User> selectUserPage(int pageNum, int pageSize, String param);
    //增加
    public int addUser(User user);
    //修改
    public int editUser(User user);
    //查找byid
    public User queryUserById(Integer id);
    //删除byid
    public int delUserById(Integer id);
}
