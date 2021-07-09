package com.haopeng.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haopeng.boot.bean.User;

public interface UserService extends IService<User> {

    void login();

    void registor();
}
