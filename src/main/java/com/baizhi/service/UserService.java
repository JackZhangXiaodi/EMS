package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
//    展示所有的用户
    List<User> findAll(Integer page,Integer end);
//    查询数据的有效条数
    Integer findCount();
//    根据id查询用户个人信息
    User findOne(String id);
//    添加用户信息
    void add(User user);

//    修改用户信息
    void modify(User user);

//    删除用户
    void remove(String id);
}
