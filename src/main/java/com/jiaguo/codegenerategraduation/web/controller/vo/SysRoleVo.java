package com.jiaguo.codegenerategraduation.web.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "请求实体: 系统角色管理表", description = "系统角色管理表")
public class SysRoleVo {

    @ApiModelProperty(value = "角色id", name = "roleId", example = "1", required = true)
    private int roleId;
    @ApiModelProperty(value = "角色名称", name = "roleName", example = "管理员", required = true)
    private String roleName;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-06-30 10:56:00", required = true)
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createUser", example = "1", required = true)
    private String createBy;
    @ApiModelProperty(value = "修改时间", name = "updateTime", example = "2020-06-30 10:56:00", required = true)
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updateUser", example = "1", required = true)
    private String updateBy;

    @ApiModelProperty(value = "资源权限集合", name = "menuList", example = "[{},{}]", required = true)
    private List<SysMenuVo> menuList;

}
