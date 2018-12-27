package com.baizhi.entity;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable {
    private String adminId;
    private String username;
    private String realName;
    private String password;
    private String sex;

    public Admin() {
        super();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) &&
                Objects.equals(username, admin.username) &&
                Objects.equals(realName, admin.realName) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(sex, admin.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, username, realName, password, sex);
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Admin(String adminId, String username, String realName, String password, String sex) {
        this.adminId = adminId;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.sex = sex;
    }
}
