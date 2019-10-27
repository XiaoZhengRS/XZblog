package com.xiaozhengkeji.blog.entitys;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户权限组实体类")
public class UserPreEntity {
    @ApiModelProperty("唯一标识")
    private Integer id;
    @ApiModelProperty("用户ID")
    private Integer userid;
    @ApiModelProperty("用户权限组")
    private JSON userpre;
}
