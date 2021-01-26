package com.yuanbao.example.controller;

import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.RolesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RolesService rolesService;

    @ApiOperation(value = "欢迎",notes = "返回欢迎页面")
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @ApiOperation(value = "所有内容",notes = "返回所有信息")
    @RequestMapping("/AllRoles")
    public String ShowRoles(Model model){
        List<Roles> roles = rolesService.findAll();
        model.addAttribute("roles",roles);
        return "Roles/AllRoles";
    }

    @ApiOperation(value = "删除",notes = "根据id删除对应成员信息")
    @ApiImplicitParam(name="id",value = "成员编号",required = true,dataType = "Integer")
    @RequestMapping("/deleteRoles")
    public String DeleteRoles(Integer id){
        System.out.println(id);
        rolesService.deleteById(id);
        return "redirect:/AllRoles";
    }

    @ApiOperation(value = "更新1",notes = "根据id寻找对应成员信息")
    @ApiImplicitParam(name="id",value = "成员编号",required = true,dataType = "Integer")
    @RequestMapping("/updateRoles")
    public String updateRoles(Model model, Integer id){
        Roles roles1 = rolesService.findById(id);
        model.addAttribute("roles1",roles1);
        return "Roles/EditRoles";
    }


    @ApiOperation(value = "更新2",notes = "更新对应成员信息并返回到所有成员信息页面")
    @ApiImplicitParam(name="roles",value = "成员实体",required = true,dataType = "Roles")
    @RequestMapping("/EditRoles")
    public String EditRoles(Roles roles){
        System.out.println(roles);
        rolesService.updateRoles(roles);
        return "redirect:/AllRoles";
    }

    @ApiOperation(value = "插入",notes = "返回增加角色页面")
    @RequestMapping("/insert")
    public String insert(){
        return "Roles/AddRoles";
    }

    @ApiOperation(value = "插入2",notes = "插入成员信息并返回所有成员信息页面")
    @ApiImplicitParam(name="roles",value = "成员实体",required = true,dataType = "Roles")
    @RequestMapping("/insertRoles")
    public String insertRoles(Roles roles){
        rolesService.insertRoles(roles);
        return "redirect:/AllRoles";
    }

    @RequestMapping("/FindById")
    @ApiImplicitParam(name="id",value = "成员编号",required = true,dataType = "Integer")
    public String FindById(Model model,Integer id){
        Roles roles2 = rolesService.findById(id);
        model.addAttribute("roles2",roles2);
        return "Roles/FindById";
    }

}