package com.baizhi.entity;

import java.io.Serializable;
import java.util.Objects;

/***
 * 角色管理类
 */
public class Role implements Serializable {
    private String id;
    private String roleName;//角色名称
    private String roleTag;//角色标签

    public Role() {
        super();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleTag, role.roleTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, roleTag);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public Role(String id, String roleName, String roleTag) {
        this.id = id;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }
}
