package com.baizhi.realm;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;

    /**
     *获取授权数据的方法 编程式开发
     *
     * 如何解决多次调用授权方法    ：  使用security Manager中的CacheManager 缓存管理器来解决
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //        获取身份信息
        String  username = (String) principalCollection.getPrimaryPrincipal();
//        查询角色和权限信息  获取  简单授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        查询管理员的信息
        Set<Role> roles = adminService.findRoleByUsername(username);
//         判断角色是否为空
        if(roles!=null && roles.size()!=0){
//            遍历这个set集合
            roles.forEach(role -> {
//                将遍历出来的角色添加到 简单授权信息对象 中
                info.addRole(role.getRoleTag());
            });
        }
//        获取角色所对应的权限
        Set<Permission> permissions = adminService.findPermissionByUsername(username);
//        判断角色所对应的权限
        if(permissions!=null && permissions.size()!=0){
            permissions.forEach(permission -> {
//                主体 绑定权限
                info.addStringPermission(permission.getPermissionTag());
            });
        }
        return info;
    }

    /**
     *
     * 获取认证信息的方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        强制类型转换
        UsernamePasswordToken upToken=(UsernamePasswordToken)token;
        String username = upToken.getUsername();
//
        Admin admin = adminService.login(username);
        if(admin.getUsername().equals(username)){
            return new SimpleAccount(admin.getUsername(),admin.getPassword(), UUID.randomUUID().toString());
        }
        return null;
    }
}
