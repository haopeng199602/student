package com.haopeng.boot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haopeng.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
