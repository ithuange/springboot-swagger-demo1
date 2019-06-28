package com.zhuzhixu.adminproject.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    public static String getMD5(String object){
        return DigestUtils.md5DigestAsHex(object.getBytes());
    }

}
