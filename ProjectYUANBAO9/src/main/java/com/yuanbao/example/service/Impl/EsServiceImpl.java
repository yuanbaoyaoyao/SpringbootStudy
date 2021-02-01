package com.yuanbao.example.service.Impl;

import com.yuanbao.example.dao.RolesDao;
import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.repository.EsRoleRepository;
import com.yuanbao.example.service.EsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EsServiceImpl implements EsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsServiceImpl.class);
    @Autowired
    private RolesDao rolesDao;
    @Autowired
    private EsRoleRepository esRoleRepository;

    @Override
    public int importAll() {
        List<Roles> rolesList = rolesDao.findAll();
        Iterable<Roles> rolesIterable = esRoleRepository.saveAll(rolesList);
        Iterator<Roles> iterator = rolesIterable.iterator();
        int result = 0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        esRoleRepository.deleteById(id);
    }

    @Override
    public Roles create(Integer id) {
        Roles result = null;
        Roles roles= rolesDao.findById(id);
        result = esRoleRepository.save(roles);
        return result;
    }

    @Override
    public Page<Roles> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return esRoleRepository.findByName(keyword,pageable);
    }
}
