package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;

import java.util.Set;

public interface AdminService {
//    登陆
    Admin login(String username);

//    注册
    void register(Admin admin);

//    根据用户名字查询所对应的角色
    Set<Role> findRoleByUsername(String username);

//    根据用户名字查询所对应的角色的权限控制
    Set<Permission> findPermissionByUsername(String username);
}
