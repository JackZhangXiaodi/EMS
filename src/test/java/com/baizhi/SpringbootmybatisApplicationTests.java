package com.baizhi;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.LogDAO;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.LogService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmybatisApplicationTests {
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LogService logService;
    @Test
    public void contextLoads() {
        Admin admin = adminDAO.queryByName("张小弟");
        System.out.println(admin);
    }
    @Test
    public void test() {
        List<User> all = userService.findAll(0,1);
        for (User user : all) {
            System.out.println(user);
        }

    }
    @Test
    public void test3(){
        Integer integer = userDAO.queryCounts();
        System.out.println(integer);
    }
    @Test
    public void test4(){
        List<User> users = userDAO.queryAll(0, 1);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test5(){
        List<Log> logs = logService.findAll(0,1);
        for (Log log : logs) {
            System.out.println(log);
        }
    }
}

