package com.yuanbao.example.service;


import com.yuanbao.example.domain.Roles;

import java.util.List;
import java.util.Optional;

public interface MongoService {
    int create(Roles roles);
    int delete(List<String> ids);
    Optional<Roles> list(String id);
}
