package com.yuanbao.example.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yuanbao.example.common.api.CommonResult;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.RedisService;
import com.yuanbao.example.service.RolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(tags = "RedisController" ,description = "redis测试")
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private RolesService rolesService;

    @ApiOperation("测试简单缓存")
    @RequestMapping(value = "/simpleTest",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Roles> simpleTest(){
        List<Roles> rolesList = rolesService.findAll();
        Roles roles = rolesList.get(0);
        String key = "redis:simple:" +roles.getId();
        redisService.set(key,roles);
        Roles roles1 =  (Roles) redisService.get(key);
        return CommonResult.success(roles1);
    }

    @ApiOperation("测试Hash结构的缓存")
    @RequestMapping(value = "/hashTest" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Roles> hashTest(){
        List<Roles> rolesList = rolesService.findAll();
        Roles roles = rolesList.get(0);
        String key = "redis:simple:" +roles.getId();
        Map<String,Object> value = BeanUtil.beanToMap(roles);
        Roles roles1 = BeanUtil.mapToBean(value,Roles.class,true);
        return CommonResult.success(roles1);
    }

    @ApiOperation("测试Set结构的缓存")
    @RequestMapping(value = "/setTest",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Set<Object>> setTest(){
        List<Roles> rolesList = rolesService.findAll();
        String key = "redis:set:all";
        redisService.sAdd(key,(Object[]) ArrayUtil.toArray(rolesList,Roles.class));
        redisService.sRemove(key,rolesList.get(0));
        Set<Object> cachedRolesList = redisService.sMembers(key);
        return CommonResult.success(cachedRolesList);
    }

    @ApiOperation("测试List结构的缓存")
    @RequestMapping(value = "/listTest",method = RequestMethod.GET)
    public CommonResult<List<Object>> listTest(){
        List<Roles> rolesList = rolesService.findAll();
        String key = "redis:list:all";
        redisService.lPushAll(key,(Object[]) ArrayUtil.toArray(rolesList,Roles.class));
        redisService.lRemove(key,1,rolesList.get(0));
        List<Object> cachedRolesList = redisService.lRange(key,0,3);
        return CommonResult.success(cachedRolesList);
    }
}
