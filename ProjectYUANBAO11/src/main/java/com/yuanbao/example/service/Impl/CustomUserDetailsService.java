package com.yuanbao.example.service.Impl;

import com.yuanbao.example.domain.SysRole;
import com.yuanbao.example.domain.SysUser;
import com.yuanbao.example.domain.SysUserRole;
import com.yuanbao.example.service.SysRoleService;
import com.yuanbao.example.service.SysUserRoleService;
import com.yuanbao.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayDeque<>();

        SysUser user = userService.findByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        for(SysUserRole userRole:userRoles){
            SysRole role = roleService.findById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getName(),user.getPassword(),authorities);
    }
}
