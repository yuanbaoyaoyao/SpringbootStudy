package com.yuanbao.example.dao;

import com.yuanbao.example.domain.Roles;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RolesDao {

    //获取全部人员信息
    @Select("select * from roles")
    List<Roles> findAll();

    //根据id查询人员信息
    @Select("select * from roles where id=#{id}")
    Roles findById(String id);

    //新增人员信息
    @Insert("insert into roles(id,name,love) values(#{id},#{name},#{love})")
    void insertRoles(Roles roles);

    //修改人员信息
    @Update("update roles set name=#{name},love=#{love} where id=#{id}")
    void updateRoles(Roles roles);

    //根据id删除人员信息
    @Delete("delete from roles where id=#{id}")
    void deleteById(String id);

}
