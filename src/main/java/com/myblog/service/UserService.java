package com.myblog.service;

import com.baomidou.mybatisplus.service.IService;
import com.myblog.entity.UserEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by YoungM25 on 2017/11/30.
 */
public interface UserService  extends IService<UserEntity> {


    List<UserEntity> queryList();
    
    UserEntity selectByOpenId(String opendId);

    /**
     * 登录时，更新用户信息
     */
    UserEntity updateUserInfo(UserEntity user);
    
    Integer saveUserMessage(UserEntity user);

}
