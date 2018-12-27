package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Set<Role> findRoleByUsername(String username) {
        Set<Role> roles = adminDAO.queryByRolesUsername(username);
        return roles;
    }

    @Override
    public Set<Permission> findPermissionByUsername(String username) {
        Set<Permission> permissions = adminDAO.queryPermissionsByUsername(username);
        return permissions;
    }

    @Override
    public Admin login(String username) {
        Admin admin1 = adminDAO.queryByName(username);
        /*if(admin1!=null){
            if (admin1.getPassword().equals(admin.getPassword())) {
                    return admin1;
                }
                throw new RuntimeException("密码错误");
            }
            throw new RuntimeException("该用户不存在");
        }*/
        return admin1;
    }

    @Override
    public void register(Admin admin) {
        admin.setAdminId(UUID.randomUUID().toString());
        adminDAO.insert(admin);
    }
}
