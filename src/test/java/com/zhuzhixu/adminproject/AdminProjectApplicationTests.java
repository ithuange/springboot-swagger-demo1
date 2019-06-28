package com.zhuzhixu.adminproject;

import com.zhuzhixu.adminproject.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminProjectApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(MD5Util.getMD5("123456"));
//        System.out.println(MD5Util.decodeMD5(MD5Util.getMD5("12123456")));
    }

}
