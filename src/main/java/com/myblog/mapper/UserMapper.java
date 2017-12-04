package com.myblog.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.myblog.entity.UserEntity;

import java.util.List;

/**
 * @author:zyk
 * @Description:用户
 * @Date:Create in 14:44 2017/11/29
 * @Modified By:
 **/
//@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询全部用户
     *
     * @return
     */
    List<UserEntity> queryList();
}
