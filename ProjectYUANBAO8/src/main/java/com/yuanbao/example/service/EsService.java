package com.yuanbao.example.service;

import com.yuanbao.example.domain.Roles;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 人员搜索管理
 */
public interface EsService {
    /**
     *  从数据库中导入所有信息到ES
     */
    int importAll();

    /**
     * 根据id删除人员信息
     */
    void delete(Integer id);

    /**
     * 根据id创建人员信息
     */
    Roles create(Integer id);


    /**
     * 根据关键字搜索人员
     */
    Page<Roles> search(String keyword, Integer pageNum, Integer pageSize);

}
