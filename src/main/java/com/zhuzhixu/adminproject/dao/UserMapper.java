package com.zhuzhixu.adminproject.dao;

import com.zhuzhixu.adminproject.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user")
    List<UserEntity> getAllUser();

    @Select("select * from t_user where username = #{username}")
    UserEntity getUserEntityByUsername(String username);

    @Select("select * from t_user where id = #{id}")
    UserEntity getUserEntityById(long id);

    @Insert("insert into t_user(username,password) values (#{username},#{password})")
    void insertUserEntity(String username, String password);
}
