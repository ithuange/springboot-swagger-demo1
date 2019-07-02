package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(UserException.class)
    public String userExceptionHandle(Exception e , HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        return "forward:/error";
    }
}
