package com.yuanbao.example.dao;

import com.yuanbao.example.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole findById(Integer id);
}
