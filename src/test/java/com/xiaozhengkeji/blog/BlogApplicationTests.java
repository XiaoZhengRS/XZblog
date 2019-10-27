package com.xiaozhengkeji.blog;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiaozhengkeji.blog.mapper.UserPasswordMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserPasswordMapper userPasswordMapper;

    @Test
    void contextLoads() {
        List<String> data = new ArrayList<>();
        data.add("ar");
        data.add("admin");
        logger.info(JSONArray.toJSONString(data));
    }

}
