package com.yuanbao.example.repository;

import com.yuanbao.example.domain.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRoleRepository extends ElasticsearchRepository<Roles,String>{
    Page<Roles> findByName(String name, Pageable page);
}
