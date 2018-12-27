package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
//    展示所有用户
    public String showAll(Model model,Integer page){
        if(page==null || page==0){
            page=1;
        }
        //       当前页码
        model.addAttribute("page",page);
        //起始条数 , 当前页码*当前页码条数
        Integer pageC =(page-1)*5;
        //查询数据有效条数
        Integer count = userService.findCount();
        //总页码
        Integer pageNums;
        if(count%5==0){
            pageNums=count/5;
        }else{
            pageNums=count/5+1;
        }
        //总页码
        model.addAttribute("pageNums",pageNums);
        //结束条数
        Integer end=page*5;
        List<User> all = userService.findAll(pageC,end);
        model.addAttribute("user",all);
        return "showAll";
    }
//    添加用户信息
    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/showAll";
    }
    @RequestMapping("/findOne")
    public String findOne(String id,Model model){
        User one = userService.findOne(id);
        model.addAttribute("users",one);
        return "updateEmp";
    }
//    修改用户信息
    @RequestMapping("/update")
    public String update(User user){
        userService.modify(user);
        return "redirect:/user/showAll";
    }
//    删除用户信息
    @RequestMapping("/delete")
    public String delete(String id){
        userService.remove(id);
        return "redirect:/user/showAll";
    }
}
