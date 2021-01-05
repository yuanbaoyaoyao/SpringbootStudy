package com.yuanbao.example.service;

import com.yuanbao.example.domain.SysUser;

public interface SysUserService {
    SysUser findById(Integer id);

    SysUser findByName(String name);

}
