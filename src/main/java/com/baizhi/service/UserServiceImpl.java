package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;

    @Override
    public Integer findCount() {
        Integer integer = userDAO.queryCounts();
        return integer;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll(Integer page,Integer end) {
        List<User> users = userDAO.queryAll(page,5);
        return users;
    }
    @Override
    public User findOne(String id) {
        User user = userDAO.queryOne(id);
        return user;
    }
    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.insert(user);
    }

    @Override
    public void modify(User user) {
        userDAO.update(user);
    }

    @Override
    public void remove(String id) {
        userDAO.delete(id);
    }
}
