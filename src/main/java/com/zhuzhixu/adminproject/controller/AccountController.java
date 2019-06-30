package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping("/account")
    public String account(){
        return "account";
    }
}
