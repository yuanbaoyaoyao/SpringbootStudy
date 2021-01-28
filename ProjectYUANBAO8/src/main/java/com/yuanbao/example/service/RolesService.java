package com.yuanbao.example.service;

import com.yuanbao.example.domain.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolesService {
    //获取全部人员信息
    List<Roles> findAll();

    //根据id查询人员信息
    Roles findById(Integer id);

    //新增人员信息
    void insertRoles(Roles roles);

    //修改人员信息
    void updateRoles(Roles roles);

    //根据id删除人员信息
    void deleteById(Integer id);
}
