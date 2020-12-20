package com.yuanbao.example.domain;

public class Roles {
    private Integer id;
    private String roles_name;
    private String love;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles_name() {
        return roles_name;
    }

    public void setRoles_name(String roles_name) {
        this.roles_name = roles_name;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roles_name='" + roles_name + '\'' +
                ", love='" + love + '\'' +
                '}';
    }
}
