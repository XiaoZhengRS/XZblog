package com.xiaozhengkeji.blog.controller.api;

import com.alibaba.fastjson.JSON;
import com.xiaozhengkeji.blog.entitys.DocEntity;
import com.xiaozhengkeji.blog.mapper.DocMapper;
import com.xiaozhengkeji.blog.tools.codepassword.Base64;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/doc")
public class DocApi {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DocMapper docMapper;

    @RequestMapping(value = "show_id/{id}", method = RequestMethod.GET)
    public ModelAndView show_id(HttpServletRequest request, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        DocEntity docEntity = docMapper.getByIDDoc(Integer.valueOf(id));
        docMapper.addDocLL(docEntity.getLl() + 1, docEntity.getId());
        modelAndView.addObject("doc", docEntity);
        modelAndView.setViewName("show_doc");
        return modelAndView;
    }

    @RequestMapping(value = "dz/{id}", method = RequestMethod.GET)
    public ModelAndView dz_id(HttpServletRequest request, @PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        DocEntity docEntity = docMapper.getByIDDoc(Integer.valueOf(id));
        docMapper.addDocDZ(docEntity.getDj() + 1, docEntity.getId());
        modelAndView.addObject("listDoc", docMapper.getALLDoc());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "add", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request, @RequestParam Map<String, Object> params) {
        String data_tit = (String) params.get("data_title");
        String data_text = (String) params.get("data_text");
        String data_class = (String) params.get("data_class");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间，也可使用当前时间戳
        String date = df.format(new Date());
        data_text = data_text.replaceAll(" ", "+");
        logger.info(data_text);
        int doc = 0;
        doc = docMapper.addDoc(data_tit, data_class, data_text, 0, 0, date);
        return String.valueOf(doc);
    }

    @RequestMapping(value = "del/{id}", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String del(HttpServletRequest request, @PathVariable("id") String id) {
        int ret = docMapper.delDoc(Integer.valueOf(id));
        if (ret == 1) {
            return "成功!";
        }
        return "失败!";
    }
}
