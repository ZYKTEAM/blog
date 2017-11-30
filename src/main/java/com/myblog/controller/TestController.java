package com.myblog.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.myblog.entity.UserEntity;
import com.myblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Author:zyk
 * @Description:
 * @Date:Create in 11:00 2017/11/22
 * @Modified By:
 **/
@Controller
public class TestController {

    private UserService userService;

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    /**
     * 分页 PAGE
     */
    @GetMapping("/test")
    public Page<UserEntity> test() {
        return userService.selectPage(new Page<UserEntity>(0, 12));
    }

    /**
     * 增删改查 CRUD
     */
    @GetMapping("/test2")
    public UserEntity test2() {
        UserEntity user = new UserEntity();
        user.setDeptname("飒飒");
        user.setUsername("dDSDS");
        user.setCreatetime(new Date());
        userService.insert(user);
        return user;
    }
}
