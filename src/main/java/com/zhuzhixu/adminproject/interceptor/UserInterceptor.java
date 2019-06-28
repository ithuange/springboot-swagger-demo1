package com.zhuzhixu.adminproject.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user_login = request.getSession().getAttribute("USER_LOGIN");
        if(user_login == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
