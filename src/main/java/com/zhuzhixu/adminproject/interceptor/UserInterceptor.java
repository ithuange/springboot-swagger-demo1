package com.zhuzhixu.adminproject.interceptor;

import com.zhuzhixu.adminproject.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user_login = request.getSession().getAttribute("USER_LOGIN");
        if(user_login == null || ((UserEntity)user_login).getUsername()==null || ((UserEntity)user_login).getUsername().isEmpty()){
            request.getSession().invalidate();
            response.sendRedirect("/login.do");
            return false;
        }
        return true;
    }
}
