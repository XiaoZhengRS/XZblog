package com.xiaozhengkeji.blog.mapper;

import com.xiaozhengkeji.blog.entitys.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户操作Mapper
 */
public interface UserPasswordMapper {
    /**
     * 注册用户
     *
     * @param name     用户名
     * @param password 用户密码
     * @return 用户实体
     */
    @Insert("INSERT INTO user_password(`name`, `password`, `pre`) " +
            "VALUES (#{name}, #{password}, #{pre})")
    UserEntity registerUser(String name, String password, String pre);

    /**
     * 登陆用户
     *
     * @param name     用户名
     * @param password 用户密码
     * @return 用户实体
     */
    @Select("select * from user_password where name=#{name} AND password=#{password}")
    UserEntity loginUser(String name, String password);

    /**
     * 查询用户是否存在
     */
    @Select("select * from user_password where name=#{name}")
    UserEntity getUser(String name);
}
