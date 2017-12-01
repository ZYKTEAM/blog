package com.myblog.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.myblog.entity.DeptEntity;
import com.myblog.entity.UserEntity;
import com.myblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Service
public class UserService extends ServiceImpl<UserMapper,UserEntity>{

    @Autowired
    private UserMapper userMapper;


    @Cacheable(value = "user",key = "#root.targetClass+#username",unless = "#result eq null")
    public List<UserEntity> queryList(){
        return userMapper.queryList();
    }



}
