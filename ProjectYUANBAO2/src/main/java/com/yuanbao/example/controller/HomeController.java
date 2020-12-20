package com.yuanbao.example.controller;

import com.yuanbao.example.dao.RolesDao;
import com.yuanbao.example.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RolesDao rolesDao;

    @RequestMapping("/Roles")
    public String ShowRoles(Model model){
        List<Roles> roles = rolesDao.findAll();
        model.addAttribute("roles",roles);
        return "index";
    }
}