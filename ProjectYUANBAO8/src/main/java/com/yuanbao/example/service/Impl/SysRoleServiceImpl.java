package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.SysRoleMapper;
import com.yuanbao.example.domain.SysRole;
import com.yuanbao.example.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;
    @Override
    public SysRole findById(Integer id) {
        return roleMapper.findById(id);
    }
}
