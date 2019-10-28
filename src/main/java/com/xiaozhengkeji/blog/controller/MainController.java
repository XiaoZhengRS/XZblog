package com.xiaozhengkeji.blog.controller;

import com.xiaozhengkeji.blog.entitys.DocEntity;
import com.xiaozhengkeji.blog.mapper.DocMapper;
import com.xiaozhengkeji.blog.tools.ListTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class MainController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DocMapper docMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HashMap<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView();
        List<DocEntity> docEntityList = docMapper.getALLDoc();
        List<String> docClassList = new ArrayList<>();
        for (DocEntity DE : docEntityList) {
            docClassList.add(DE.getDocclass());
        }
        docClassList = ListTool.removeDuplicate(docClassList);
        modelAndView.addObject("listDocClass", docClassList);
        modelAndView.addObject("listDoc", docEntityList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, Model model, @RequestParam Map<String, Object> params) {
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        logger.info("map[" + params.toString() + "]");
        ModelAndView modelAndView = new ModelAndView();
        if (username == null || password == null) {
            model.addAttribute("msg", "请登陆!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg", "用户名不存在!");
            modelAndView.setViewName("login");
            return modelAndView;
        } catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("msg", "密码错误!");
            modelAndView.setViewName("login");
            return modelAndView;
        } catch (AuthenticationException e) {
            //验证异常
            model.addAttribute("msg", "验证异常!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/loginIs")
    public String loginis(HttpServletRequest request, @RequestParam Map<String, Object> params) {
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        logger.info("map[" + params.toString() + "]");
        ModelAndView modelAndView = new ModelAndView();
        logger.info("username---" + username);
        logger.info("password---" + password);
        return params.toString();
    }

    @RequestMapping(value = "/Editor")
    public ModelAndView Editor(HttpServletRequest request, @RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Editor");
        return modelAndView;
    }

}
