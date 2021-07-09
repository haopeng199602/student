package com.haopeng.boot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haopeng.boot.bean.User;
import com.haopeng.boot.mapper.UserMapper;
import com.haopeng.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void login() {

    }

    @Override
    public void registor() {

    }
}
