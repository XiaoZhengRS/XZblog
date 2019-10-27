package com.xiaozhengkeji.blog.config.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiaozhengkeji.blog.entitys.UserEntity;
import com.xiaozhengkeji.blog.mapper.UserPasswordMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserPasswordMapper userPasswordMapper;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        UserEntity userEntity = (UserEntity) subject.getPrincipal();
        List<String> preList = JSONArray.parseArray(userEntity.getPre(), String.class);
        for (String dataPre : preList) {
            info.addStringPermission(dataPre);
            logger.info("授权用户[" + userEntity.getName() + "]权限[" + dataPre + "]");
        }
        return null;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserEntity userEntity = userPasswordMapper.getUser(token.getUsername());
        if (userEntity == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), "");
    }
}
