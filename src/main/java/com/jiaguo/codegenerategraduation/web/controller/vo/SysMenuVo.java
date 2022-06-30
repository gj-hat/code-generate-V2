package com.jiaguo.codegenerategraduation.web.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 10:56
 * @description：资源菜单表
 * @modified By：
 * @version: 1.0
 */
@Data
@ApiModel(value = "数据库实体: 资源菜单", description = "资源菜单")
@Accessors(chain = true)
public class SysMenuVo {

    @ApiModelProperty(value = "菜单id", name = "menuId", example = "1", required = true)
    private int id;
    @ApiModelProperty(value = "菜单名称", name = "menuName", example = "系统管理", required = true)
    private String menuName;
    @ApiModelProperty(value = "菜单地址", name = "menuUrl", example = "/sys/menu", required = true)
    private String menuUrl;
    @ApiModelProperty(value = "父菜单id", name = "parentId", example = "0", required = true)
    private int menuParentId;
    @ApiModelProperty(value = "菜单类型", name = "menuType", example = "1", required = true)
    private int menuType;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-06-30 10:56:00", required = true)
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createUser", example = "1", required = true)
    private String createBy;
    @ApiModelProperty(value = "修改时间", name = "updateTime", example = "2020-06-30 10:56:00", required = true)
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updateUser", example = "1", required = true)
    private String updateBy;







}
