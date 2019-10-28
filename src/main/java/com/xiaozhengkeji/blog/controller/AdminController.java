package com.xiaozhengkeji.blog.controller;

import com.xiaozhengkeji.blog.entitys.DocEntity;
import com.xiaozhengkeji.blog.mapper.DocMapper;
import com.xiaozhengkeji.blog.tools.ListTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DocMapper docMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, Model model, @RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "show_all_doc", method = RequestMethod.GET)
    public ModelAndView show_all_doc(HttpServletRequest request, Model model, @RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listDoc", docMapper.getALLDoc());
        modelAndView.setViewName("show_all_doc");
        return modelAndView;
    }

    @RequestMapping(value = "show_all_doc_class", method = RequestMethod.GET)
    public ModelAndView show_all_doc_class(HttpServletRequest request, Model model, @RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView();
        List<DocEntity> docEntityList = docMapper.getALLDoc();
        List<String> docClassList = new ArrayList<>();
        for (DocEntity DE : docEntityList) {
            docClassList.add(DE.getDocclass());
        }
        docClassList = ListTool.removeDuplicate(docClassList);
        modelAndView.addObject("listDocClass", docClassList);
        modelAndView.setViewName("show_all_doc_class");
        return modelAndView;
    }

}
