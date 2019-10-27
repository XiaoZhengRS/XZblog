package com.xiaozhengkeji.blog.tools.codepassword;

import org.springframework.util.DigestUtils;

public class MD5 {
    public static String MD5加密(String set){
        return DigestUtils.md5DigestAsHex(set.getBytes());
    }
}
