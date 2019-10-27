package com.xiaozhengkeji.blog.mapper;

import com.alibaba.fastjson.JSON;
import com.xiaozhengkeji.blog.entitys.UserEntity;
import com.xiaozhengkeji.blog.entitys.UserPreEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 用户权限操作Mapper
 */
public interface UserPreMapper {
    /**
     * 创建默认权限
     *
     * @param id  用户id
     * @param pre 用户组名
     * @return 用户实体
     */
    @Insert("INSERT INTO user_pre(`userid`, `userpre`) " +
            "VALUES (#{id}, #{pre})")
    UserPreEntity addUserPre(Integer id, JSON pre);

    /**
     * 查询用户权限组
     *
     * @param userid 用户ID
     * @return 用户权限组实体
     */
    @Select("select * from user_pre where userid=#{userid}")
    UserPreEntity getUserPre(Integer userid);
}
