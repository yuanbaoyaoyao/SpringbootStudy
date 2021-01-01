package com.yuanbao.example.controller;

import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/AllRoles")
    public String ShowRoles(Model model){
        List<Roles> roles = rolesService.findAll();
        model.addAttribute("roles",roles);
        return "Roles/AllRoles";
    }

    @RequestMapping("/deleteRoles")
    public String DeleteRoles(Integer id){
        System.out.println(id);
        rolesService.deleteById(id);
        return "redirect:/AllRoles";
    }

    @RequestMapping("/updateRoles")
    public String updateRoles(Model model, Integer id){
        Roles roles1 = rolesService.findById(id);
        model.addAttribute("roles1",roles1);
        return "Roles/EditRoles";
    }


    @RequestMapping("/EditRoles")
    public String EditRoles(Roles roles){
        System.out.println(roles);
        rolesService.updateRoles(roles);
        return "redirect:/AllRoles";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "Roles/AddRoles";
    }

    @RequestMapping("/insertRoles")
    public String insertRoles(Roles roles){
        rolesService.insertRoles(roles);
        return "redirect:/AllRoles";
    }

    @RequestMapping("/FindById")
    public String FindById(Model model,Integer id){
        Roles roles2 = rolesService.findById(id);
        model.addAttribute("roles2",roles2);
        return "Roles/FindById";
    }

}