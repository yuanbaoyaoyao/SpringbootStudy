package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.SysUserMapper;
import com.yuanbao.example.domain.SysUser;
import com.yuanbao.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public SysUser findByName(String name) {
        return userMapper.findByName(name);
    }
}
