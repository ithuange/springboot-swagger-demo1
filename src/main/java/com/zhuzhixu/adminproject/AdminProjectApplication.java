package com.zhuzhixu.adminproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhuzhixu.adminproject.dao")
public class AdminProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminProjectApplication.class, args);
    }

}
