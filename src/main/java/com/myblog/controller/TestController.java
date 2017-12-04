package com.myblog.controller;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.myblog.entity.UserEntity;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author:zyk
 * @Description:
 * @Date:Create in 11:00 2017/11/22
 * @Modified By:
 **/
@Controller
public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 访问主页
     * @return
     */
    @RequestMapping( value = "/index")
    public String index(Model model) {
        List<UserEntity> userList = userService.queryList();
        model.addAttribute("userList",userList);
        return "index/index";
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
