package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.entity.UserEntity;
import com.zhuzhixu.adminproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String first(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String userLogin(String username, String password, HttpServletRequest request){
        UserEntity entity = userService.getUserEntity(username);
        if(entity == null){
            return "login";
        }
        Boolean flag = entity.getPassword().equals(password);
        if (flag){
            request.getSession().setAttribute("USER_LOGIN", entity);
            return "redirect:index";
        }
        request.setAttribute("message","密码错误或者用户名不存在");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
