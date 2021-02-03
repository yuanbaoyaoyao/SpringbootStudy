package com.yuanbao.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;
    private String userId;
    private String roleId;
}
