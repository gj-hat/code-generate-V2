
package com.jiaguo.codegenerategraduation.web.controller;


import com.jiaguo.codegenerategraduation.common.exception.RRException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysUserVo;
import com.jiaguo.codegenerategraduation.web.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * (SysUser)表控制层
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:30
 */
@RestController
@RequestMapping("/sysUser")
@Api(value = "系统用户管理", tags = "系统用户管理")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 分页查询所有用户
     *
     * @param params 分页对象
     * @return 所有数据
     */

    @RequestMapping(value = "/list", method = { RequestMethod.POST})
    @ApiOperation(value = "分页查询所有用户", notes = "分页查询所有用户")
    public Result selectAll(ReqParams<SysUserVo> params) {
        return this.sysUserService.pageQuery(params);
    }

    /**
     * 新增数据 角色id进行绑定
     *
     * @param sysUserVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据 角色id进行绑定")
    public Result insert(@RequestBody @Valid SysUserVo sysUserVo, BindingResult result) {
        if (result.hasErrors()) {
            String msg = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
            throw new RRException(msg);
        }
        if (sysUserVo.getRoleId() == -1) throw new RRException("请传入用户角色");

        sysUserVo.setPassword(new BCryptPasswordEncoder().encode(sysUserVo.getPassword()));
        return sysUserService.saveSysUser(sysUserVo);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "废弃: 通过主键查询单条数据", notes = "通过主键查询单条数据")
    @RequestMapping(value = "/id", method = { RequestMethod.POST})
    @Deprecated
    public Result selectOne(RequestBody id) {
        //  JiaGuo 2022/6/29:  这个业务暂时不用 已打废弃标记
        return Result.success(this.sysUserService.getById((Serializable) id));
    }


    /**
     * 修改用户和角色绑定关系
     *
     * @param sysUserVo 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据", notes = "修改用户和角色绑定关系")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody @Valid SysUserVo sysUserVo, BindingResult result) {
        if (result.hasErrors()) {
            String msg = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
            throw new RRException(msg);
        }
        return this.sysUserService.updateUser(sysUserVo);
    }

    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据", notes = "删除数据 和绑定关系 前端使用String传输")
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public Result delete(@RequestBody List<Long> idList) {
        return this.sysUserService.removeUserByIds(idList);
    }


    /**
     * 查询当前用户所具有的权限
     * @return
     */
    @RequestMapping(value = "/listByDefault", method = { RequestMethod.POST})
    @ApiOperation(value = "查询当前登录用户资源", notes = "查询当前登录用户资源集合 ")
    public Result selectByLoginUser() {
        return sysUserService.selectByLoginUser();
    }


}

