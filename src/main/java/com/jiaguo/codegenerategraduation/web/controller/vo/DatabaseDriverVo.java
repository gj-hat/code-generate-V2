package com.jiaguo.codegenerategraduation.web.controller.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * @author     ：JiaGuo
  *@emil     ：1520047927@qq.com
 * @date       ：Created in 2022/7/4
 * @description：   请求实体: 数据库连接驱动
 * @modified By：
 * @version:     1.0
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "请求实体: 数据库连接驱动", description = "这里放的是数据库的驱动程序")
public class DatabaseDriverVo {
    @ApiModelProperty(value = "驱动id", name = "id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "驱动名", name = "driverName", example = "mysql", required = true)
    private String name;
    @ApiModelProperty(value = "备注", name = "remark", example = "mysql", required = true)
    private String remark;
    @ApiModelProperty(value = "驱动地址", name = "driverUrl", example = "jdbc:mysql://localhost:3306/test", required = true)
    private String url;
    @ApiModelProperty(value = "创建时间", name = "createTime", example = "2020-06-30 10:56:00", required = true)
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "createUser", example = "1", required = true)
    private String createBy;
    @ApiModelProperty(value = "修改时间", name = "updateTime", example = "2020-06-30 10:56:00", required = true)
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updateUser", example = "1", required = true)
    private String updateBy;
//    @ApiModelProperty(value = "所属角色功能", name = "roleId", example = "1", required = true)
//    private Integer roleId = 0;
}