package com.xiaozhengkeji.blog.tools.email;

import com.xiaozhengkeji.blog.interfaces.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailTool {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 发送注册邮件 (自动生成验证连接)
     *
     * @param st   收件人邮箱
     * @param code 注册验证码
     */
    @Autowired
    private MailService mailService;

    /**
     * 发送注册成功邮件
     *
     * @param st 收件人邮箱
     */
    public void foOk(String st) {
        String url = "http://localhost:8888";
        mailService.sendHtmlMail(st, "注册成功", "点击以下连接进入官网<br>" + url);
    }
}
