package com.yuanbao.example.service;

import com.yuanbao.example.domain.SysUser;

import java.math.BigInteger;

public interface SysUserService {
    SysUser findById(String id);

    SysUser findByName(String name);

}
