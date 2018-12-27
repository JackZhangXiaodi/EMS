package com.baizhi.dao;


import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserDAO {
    //查询所有用户(起始条数，结束条数)
    List<User> queryAll(@Param("page") Integer page, @Param("end") Integer end);

    //查询数据的有效条数
    Integer queryCounts();

    //根据id查询用户
    User queryOne(String id);

    //添加用户信息
    void insert(User user);

    //修改用户信息
    void update(User user);

    //删除用户信息
    void delete(String id);
}
