package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.entity.UserEntity;
import com.zhuzhixu.adminproject.service.UserService;
import com.zhuzhixu.adminproject.util.MD5Util;
import com.zhuzhixu.adminproject.util.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String index(HttpSession session){
        session.setAttribute("userList", userService.getAllUser());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String userLogin(String username, String password, HttpServletRequest request){
        UserEntity entity = userService.getUserEntity(username);
        if(entity == null){
            return "login";
        }
        Boolean flag = entity.getPassword().equals(MD5Util.getMD5(password));
        if (flag){
            request.getSession().setAttribute("USER_LOGIN", entity);
            request.getSession().setAttribute("userList", userService.getAllUser());
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody register(String username, String password){
        userService.insertUserEntity(username, MD5Util.getMD5(password));
        return MessageBody.successMessage("注册成功");
    }


}
