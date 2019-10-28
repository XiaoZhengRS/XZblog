package com.xiaozhengkeji.blog.config;

import com.xiaozhengkeji.blog.config.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class MyShiroConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static Map<String, String> shiroF = new LinkedHashMap<String, String>();

    public MyShiroConfig() {
        //专门设置无需验证
        shiroF.put("/static/**", "anon");
        shiroF.put("/css/**", "anon");
        shiroF.put("/img/**", "anon");
        shiroF.put("/js/**", "anon");
        shiroF.put("/404", "anon");
        shiroF.put("/error", "anon");
        shiroF.put("/login.html", "anon");
        shiroF.put("/login", "anon");
        shiroF.put("/text", "anon");
        shiroF.put("/index.html", "anon");
        shiroF.put("/index", "anon");
        shiroF.put("/", "anon");
        shiroF.put("/api/doc/show_all", "anon");
        shiroF.put("/api/doc/show_id/**", "anon");
        shiroF.put("/api/doc/dz/**", "anon");
        //专门设置角色验证
        shiroF.put("/Editor", "authc");
        shiroF.put("/api/doc/add", "authc");
        shiroF.put("/api/doc/del/**", "authc");
        shiroF.put("/admin/**", "authc");
    }

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean()
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        logger.info("设置安全管理器:ShiroFilterFactoryBean -> defaultWebSecurityManager()");
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器, 可以实现权限相关拦截器
         *  常用的过滤器
         *      anon:  无需授权认证(登陆) 可以访问
         *      authc: 必须认证才可以访问
         *      user:  如果使用rememberMe的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      pole:  该资源必须得到角色权限才可以访问
         * */
/*        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/static/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/404", "anon");
        filterMap.put("/error", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/text", "anon");
        filterMap.put("/index.html", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/**", "authc");*/
        shiroF.put("/**", "authc");
        //修改跳转
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroF);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        logger.info("关联:关联realm -> getRealm()");
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        logger.info("realm -> new");
        return new UserRealm();
    }
}
