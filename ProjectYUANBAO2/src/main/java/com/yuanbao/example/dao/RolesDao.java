package com.yuanbao.example.dao;

import com.yuanbao.example.domain.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolesDao {
    @Select("select * from roles")
    List<Roles> findAll();
}
