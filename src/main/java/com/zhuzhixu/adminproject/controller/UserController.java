package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.entity.UserEntity;
import com.zhuzhixu.adminproject.service.UserService;
import com.zhuzhixu.adminproject.util.MD5Util;
import com.zhuzhixu.adminproject.util.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/","/login.do"})
    public String first(){
        return "login";
    }


    @RequestMapping("/index.do")
    public String index(HttpSession session){
        session.setAttribute("userList", userService.getAllUser());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request){
        UserEntity entity = userService.getUserEntity(username);
        if(entity == null){
            request.getSession().setAttribute("message","密码错误或者用户名不存在");
            return "login";
        }
        Boolean flag = entity.getPassword().equals(MD5Util.getMD5(password));
        if (flag){
            request.getSession().invalidate();
            request.getSession().setAttribute("USER_LOGIN", entity);
            request.getSession().setAttribute("userList", userService.getAllUser());
            return "index";
        }
        request.getSession().setAttribute("message","密码错误或者用户名不存在");
        return "login";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody register(String username, String password){
        userService.insertUserEntity(username, MD5Util.getMD5(password));
        return MessageBody.successMessage("注册成功");
    }


}
