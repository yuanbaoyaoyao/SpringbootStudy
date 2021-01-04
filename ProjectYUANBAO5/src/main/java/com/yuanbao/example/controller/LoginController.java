package com.yuanbao.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String Home(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户："+name);
        return "Security/home";
    }

    @RequestMapping("/login")
    public String Login(){
        return "Security/login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('Role_Admin')")
    public String printAdmin(){
        return "已有Role_Admin角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('Role_Admin')")
    public String printUser(){
        return "已有Role_User角色";
    }
}
