package com.jiaguo.codegenerategraduation.web.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
@TableName("sys_menu")
public class SysMenu {

    @ApiModelProperty(value = "菜单id", name = "menuId", example = "1", required = true)
    @TableId(value = "menu_id")
    private int id;
    @ApiModelProperty(value = "菜单名称", name = "menuName", example = "系统管理", required = true)
    @TableField("menu_name")
    private String menuName;
    @ApiModelProperty(value = "菜单地址", name = "menuUrl", example = "/sys/menu", required = true)
    @TableField("menu_url")
    private String menuUrl;
    @ApiModelProperty(value = "父菜单id", name = "parentId", example = "0", required = true)
    @TableField("menu_parent_id")
    private int menuParentId;
    @ApiModelProperty(value = "菜单类型", name = "menuType", example = "1", required = true)
    @TableField("menu_type")
    private int menuType;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-07-06 10:36:46")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人", name = "createBy", example = "1")
    private String createBy;
    @ApiModelProperty(value = "更新时间", name = "updateTime", example = "2020-07-06 10:36:46")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "更新人", name = "updateBy", example = "1")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @ApiModelProperty(value = "删除标记", name = "delFlag", example = "1")
    @TableField("del_flag")
    private Integer delFlag;


}
