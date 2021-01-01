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

    @Override
    public Roles findById(Integer id) {
        return rolesDao.findById(id);
    }

    @Override
    public void insertRoles(Roles roles) {
        rolesDao.insertRoles(roles);
    }

    @Override
    public void updateRoles(Roles roles) {
        rolesDao.updateRoles(roles);
    }

    @Override
    public void deleteById(Integer id) {
        rolesDao.deleteById(id);
    }
}
