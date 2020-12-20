package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.RolesDao;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Roles> findAll() {
        return rolesDao.findAll();
    }
}
