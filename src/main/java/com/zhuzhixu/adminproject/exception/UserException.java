package com.zhuzhixu.adminproject.exception;

public class UserException extends RuntimeException{
    public UserException(){
        super("用户不存在");
    }
}
