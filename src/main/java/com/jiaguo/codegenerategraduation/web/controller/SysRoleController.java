package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.exception.RRException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.service.impl.SysRoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:41
 * @description：系统角色Controller
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/role")
@Api(value = "系统角色管理", tags = "系统角色管理")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleService;



    /**
     * 分页查询所有数据 包含资源信息
     *
     * @param params 分页对象
     * @return 所有数据
     */

    @RequestMapping(value = "/list", method = { RequestMethod.POST})
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据 包含资源信息")
    public Result selectAll(ReqParams<SysRoleVo> params) {
        return this.sysRoleService.pageQuery(params);
    }


    /**
     * 新增角色并进行资源绑定
     *
     * @param sysRoleVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增角色并进行资源绑定 ")
    public Result insert(@RequestBody @Valid SysRoleVo sysRoleVo, BindingResult result) {
        if (result.hasErrors()) {
            String msg = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
            throw new RRException(msg);
        }

        return sysRoleService.saveSysRole(sysRoleVo);
    }


    /**
     * 修改数据
     *
     * @param sysRoleVo 实体对象
     * @return 修改结果
     */
    // TODO JiaGuo 2022/7/4:  修改时候还没有做资源绑定修改
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody @Valid SysRoleVo sysRoleVo, BindingResult result) {
        if (result.hasErrors()) {
            String msg = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
            throw new RRException(msg);
        }
        return this.sysRoleService.updateRole(sysRoleVo);
    }

    /**
     * 删除角色和绑定关系
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据", notes = "删除角色和绑定关系")
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public Result delete(@RequestBody List<Integer> idList) {
        return this.sysRoleService.removeRoleByIds(idList);
    }





}
