package com.myblog.myblog.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.myblog.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:zyk
 * @Description:用户
 * @Date:Create in 14:44 2017/11/29
 * @Modified By:
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询全部用户
     *
     * @return
     */
    @Select("queryList")
    List<UserEntity> queryList();
}
