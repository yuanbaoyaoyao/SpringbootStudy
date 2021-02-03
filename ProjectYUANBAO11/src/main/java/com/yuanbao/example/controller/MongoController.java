package com.yuanbao.example.controller;

import com.yuanbao.example.common.api.CommonResult;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.MongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Controller
@Api(tags = "MongoController",description = "Mongo测试")
@RequestMapping("/Mongo")
public class MongoController {
    @Autowired
    private MongoService mongoService;

    @ApiOperation("创建id")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Roles roles){
        int count = mongoService.create(roles);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除id")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = mongoService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("展示对象")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Optional<Roles>> list(String id) {
        Optional<Roles> RolesList = mongoService.list(id);
        return CommonResult.success(RolesList);
    }
}
