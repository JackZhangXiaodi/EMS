package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface AdminDAO {
    @Select("select adminId,username,realName,password,sex from t_admin where username=#{username}")
    Admin queryByName(String username);

    @Insert("insert into t_admin (adminid,username,realname,password,sex) values(#{adminId},#{username},#{realName},#{password},#{sex})")
    void insert(Admin admin);
//    查询主体所对应的角色
    @Select("select id,role_name roleName,role_tag roleTag from t_role where id in(select role_id from t_admin_role where admin_id=(select adminId from t_admin where username=#{username}))")
    Set<Role> queryByRolesUsername(String username);

//     根据角色id来查询所对应的访问权限
    @Select("select id,resourceName,resourceUrl,resourceTag,permissionTag from t_permission where id in(select permission_id from t_role_permission where role_id in(select id from t_role where id in(select role_id from t_admin_role where admin_id = (select adminId from t_admin where username=#{username} ))))")
    Set<Permission> queryPermissionsByUsername(String username);
}
