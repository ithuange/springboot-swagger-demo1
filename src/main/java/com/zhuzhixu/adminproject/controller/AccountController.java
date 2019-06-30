package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.entity.UserEntity;
import com.zhuzhixu.adminproject.service.UserService;
import com.zhuzhixu.adminproject.util.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping("/accounts")
    public String account(HttpSession session){
        session.setAttribute("userList", userService.getAllUser());
        return "accounts";
    }

    @RequestMapping(value = "/getUserDetail", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody getUserDetail(@RequestParam("id") String id){
        UserEntity userEntity = userService.getUserEntity(Long.parseLong(id));
        if(userEntity != null){
            return MessageBody.successMessage("查询成功",userEntity);
        }
        return MessageBody.failMessage("查询失败");
    }
}
