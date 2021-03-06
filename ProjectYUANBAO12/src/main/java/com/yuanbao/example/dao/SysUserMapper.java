package com.yuanbao.example.dao;

import com.yuanbao.example.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;

@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where id = #{id}")
    SysUser findById(String id);

    @Select("select * from sys_user where name = #{name}")
    SysUser findByName(String name);
}
