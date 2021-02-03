package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.RolesDao;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Roles> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public Roles findById(String id) {
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
    public void deleteById(String id) {
        rolesDao.deleteById(id);
    }
}
