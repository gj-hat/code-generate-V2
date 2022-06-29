package com.jiaguo.codegenerategraduation.web.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * (SysUser)表实体类
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:33
 */

@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    //用户名  不能为空
    @TableField(value = "username")
    @NotBlank(message = "用户名不能为空")
    private String username;
    //密码
    @TableField("password")
    private String password;
    //昵称
    @TableField("nickname")
    private String nickname;
    //创建时间
    @TableField("create_time")
    @NotBlank(message = "创建时间不能为空")
    private Date createTime;
    //创建人
    @TableField("create_by")
    @NotBlank(message = "创建人不能为空")
    private String createBy;
    //更新时间
    @TableField("update_time")
    @NotBlank(message = "更新时间不能为空")
    private Date updateTime;
    //更新人
    @TableField("update_by")
    private String updateBy;

    @TableField("del_flag")
    private int delFlag;


}


