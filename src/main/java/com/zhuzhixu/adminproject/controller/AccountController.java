package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.entity.UserEntity;
import com.zhuzhixu.adminproject.service.UserService;
import com.zhuzhixu.adminproject.util.MD5Util;
import com.zhuzhixu.adminproject.util.MessageBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RestController
@Api(value = "SayController|一个用来测试swagger注解的控制器")
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping("/accounts.do")
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String account(HttpSession session){
        session.setAttribute("userList", userService.getAllUser());
        return "accounts";
    }
    @GetMapping("/findAll")
    public String findAll(@RequestParam("id") String id){
        List list = userService.findAll();
        return "ok";
    }

    @RequestMapping(value = "/getUserDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody getUserDetail(@RequestParam("id") String id){
        UserEntity userEntity = userService.getUserEntity(Long.parseLong(id));
        if(userEntity != null){
            return MessageBody.successMessage("查询成功",userEntity);
        }
        return MessageBody.failMessage("查询失败");
    }
    @RequestMapping(value = "/accounts.do/delete", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody deleteUser(String id){
        userService.delteUserEntity(Long.parseLong(id));
        return MessageBody.successMessage("删除成功");
    }

    @RequestMapping(value = "/accounts.do/update", method = RequestMethod.POST)
    @ResponseBody
    public MessageBody updateUser(String id, String username, String password){
        userService.updateUserEntity(username, MD5Util.getMD5(password), Long.parseLong(id));
        return MessageBody.successMessage("更新成功");
    }
}
