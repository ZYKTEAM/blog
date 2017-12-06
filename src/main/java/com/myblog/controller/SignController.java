package com.myblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zyk
 * @Description:
 * @Date:Create in 11:00 2017/11/22
 * @Modified By:
 **/
@Controller
public class SignController {

    
    @RequestMapping( value = "/signIn")
    public String signIn(Model model) {
        return "content/sign_in";
    }
    
    @RequestMapping( value = "/signUp")
    public String signUp(Model model) {
        return "content/sign_up";
    }
}
