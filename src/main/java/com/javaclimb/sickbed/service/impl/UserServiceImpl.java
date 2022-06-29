package com.javaclimb.sickbed.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Room;
import com.javaclimb.sickbed.entity.User;
import com.javaclimb.sickbed.mapper.UserMapper;
import com.javaclimb.sickbed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户表接口实现类
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByusername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public IPage<User> selectUserPage(int pageNum, int pageSize, String param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("username", param);
        }
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int delUserById(Integer id) {
        return userMapper.deleteById(id);
    }


}
