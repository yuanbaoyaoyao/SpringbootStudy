package com.yuanbao.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;
    private String id;
    private String name;
}
