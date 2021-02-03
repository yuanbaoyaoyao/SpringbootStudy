package com.yuanbao.example.service.Impl;

import com.yuanbao.example.domain.Roles;
import com.yuanbao.example.repository.MongoRolesRepository;
import com.yuanbao.example.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoRolesRepository mongoRolesRepository;
    @Override
    public int create(Roles roles) {
        roles.setId(null);
        roles.setCreateTime(new Date());
        mongoRolesRepository.save(roles);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<Roles> deleteList = new ArrayList<>();
        for(String id:ids){
            Roles Roles = new Roles();
            Roles.setId(id);
            deleteList.add(Roles);
        }
        mongoRolesRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public Optional<Roles> list(String id) {
        return mongoRolesRepository.findById(id);
    }
}
