package com.yuanbao.example.service;

import com.yuanbao.example.domain.SysUserRole;

import java.util.List;

public interface SysUserRoleService {
    List<SysUserRole> listByUserId(String id);
}
