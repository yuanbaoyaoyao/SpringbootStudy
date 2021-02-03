package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.SysUserRoleMapper;
import com.yuanbao.example.domain.SysUserRole;
import com.yuanbao.example.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Override
    public List<SysUserRole> listByUserId(String userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
