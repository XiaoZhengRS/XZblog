package com.xiaozhengkeji.blog.tools;

import javax.servlet.http.Cookie;

public class CookieTool {
    /**
     * 取Cookie值
     *
     * @param cookies cokkis[]值
     * @param name    cokkis属性名
     */
    public static String getCookie(String name, Cookie[] cookies) {
        //遍历cookie集合并判断是否有自己想要的指定cookie如果有则返回指定cookie的值，如果没有则返回空字符串
        if (cookies == null) {
            return "";
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return "";
    }

}
