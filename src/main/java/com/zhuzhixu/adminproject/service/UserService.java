package com.zhuzhixu.adminproject.service;

import com.zhuzhixu.adminproject.dao.UserMapper;
import com.zhuzhixu.adminproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> getAllUser(){
        return userMapper.getAllUser();
    }

    public UserEntity getUserEntity(String username){
        return userMapper.getUserEntityByUsername(username);
    }

    public void insertUserEntity(String username, String password){
        userMapper.insertUserEntity(username, password);
    }

    public UserEntity getUserEntity(long id){
        return userMapper.getUserEntityById(id);
    }

    public void delteUserEntity(long id){
        userMapper.deleteUserEntity(id);
    }

    public void updateUserEntity(String username, String password, long id){
        userMapper.updateUserEntity(username, password, id);
    }
}
