package com.xiaozhengkeji.blog.services;

import com.xiaozhengkeji.blog.config.MyShiroConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * 全局权限组
 */
@Configuration
public class PermissionsService {
    private Logger logger = LoggerFactory.getLogger(getClass());


    public PermissionsService() {
        Set<String> myShiroPreUrl = MyShiroConfig.shiroF.keySet();
        logger.info("权限组管理器:MyShiroPreConfig");
        for (String url : myShiroPreUrl) {
            logger.info("路径[" + url + "]\t--->\t授权资源\t--->\t[" + MyShiroConfig.shiroF.get(url) + "]");
        }

    }


}
