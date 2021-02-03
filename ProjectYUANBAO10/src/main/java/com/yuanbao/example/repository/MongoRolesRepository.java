package com.yuanbao.example.repository;

import com.yuanbao.example.domain.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoRolesRepository extends MongoRepository<Roles,String> {
}
