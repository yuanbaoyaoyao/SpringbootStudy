package com.yuanbao.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;
    private Integer id;
    public String name;
    private String password;
}
