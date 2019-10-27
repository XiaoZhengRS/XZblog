package com.xiaozhengkeji.blog.mapper;

import com.xiaozhengkeji.blog.entitys.DocEntity;
import com.xiaozhengkeji.blog.entitys.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface DocMapper {
    /**
     * 发布新文档
     *
     * @param tabname  文档标题
     * @param docclass 文档类型
     * @param doctext  文档内容
     * @param dj       文档点赞
     * @param ll       文档浏览
     * @param date     文档发布时间
     * @return 文档实体
     */
    @Insert("INSERT INTO document(`tabname`, `docclass`, `doctext`, `dj`, `ll`, `date`) " +
            "VALUES (#{tabname}, #{docclass}, #{doctext}, #{dj}, #{ll}, #{date})")
    int addDoc(String tabname, String docclass, String doctext, int dj, int ll, String date);

    /**
     * 获取全部文档
     *
     * @return 全部已经发布的文档
     */
    @Select("select * from document")
    List<DocEntity> getALLDoc();

    /**
     * 按类型查询文档
     *
     * @return 指定类型已经发布的文档
     */
    @Select("select * from document where docclass=#{docclass}")
    List<DocEntity> getByClassDoc(String docclass);

    /**
     * 按ID查询文档
     *
     * @return 指定ID已经发布的文档
     */
    @Select("select * from document where id=#{id}")
    DocEntity getByIDDoc(Integer id);
}
