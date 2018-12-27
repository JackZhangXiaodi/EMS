package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
//   管理员登陆
    @RequestMapping("/login")
    public String  login(Admin admin,Boolean remember){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(admin.getUsername(),admin.getPassword(),remember));
        } catch (UnknownAccountException uae){
            return "redirect:/views/login.jsp?username=error";
        } catch (IncorrectCredentialsException ice){
            return "redirect:/views/login.jsp?password=error";
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        /*Admin login = adminService.login(admin);
        session.setAttribute("admin",login);*/
        return "redirect:/user/showAll";
    }
//    管理员添加
    @RequestMapping("/register")
    public String register(Admin admin){
        adminService.register(admin);
        return "redirect:/views/login.jsp";
    }

//    登出
    @RequestMapping("logOut")
    public String logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/views/login.jsp";
    }
}
