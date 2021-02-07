package com.yuanbao.example.controller;

import com.yuanbao.example.common.api.CommonPage;
import com.yuanbao.example.common.api.CommonResult;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.EsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags="EsRolesController",description = "搜索人物")
@RequestMapping("/esRoles")
public class EsRolesController {
    @Autowired
    private EsService esService;

    @ApiOperation(value = "导入所有数据库中人员到ES")
    @RequestMapping(value = "/importAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList(){
        int count = esService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除人员")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object>delete(@PathVariable String id){
        esService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建人员")
    @RequestMapping(value="/create/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Roles>create(@PathVariable String id){
        Roles roles = esService.create(id);
        if(roles!=null){
            return CommonResult.success(roles);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "搜索")
    @RequestMapping(value="/search/simple",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Roles>>search(@RequestParam(required = false)String keyword,
                                                 @RequestParam(required = false,defaultValue = "0")Integer pageNum,
                                                 @RequestParam(required = false,defaultValue = "5")Integer pageSize){
        Page<Roles> rolesPage = esService.search(keyword,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(rolesPage));
    }
}
