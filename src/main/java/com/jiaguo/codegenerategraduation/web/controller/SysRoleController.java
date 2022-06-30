package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.exception.RRException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysRoleVo;
import com.jiaguo.codegenerategraduation.web.service.impl.SysRoleServiceImpl;
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
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleService;



    /**
     * 分页查询所有数据
     *
     * @param params 分页对象
     * @return 所有数据
     */

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    public Result selectAll(ReqParams<SysRoleVo> params) {
        return this.sysRoleService.pageQuery(params);
    }


    /**
     * 新增数据
     *
     * @param sysRoleVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  ")
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
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据", notes = "删除数据 前端使用String传输")
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public Result delete(@RequestBody List<Integer> idList) {
        return this.sysRoleService.removeRoleByIds(idList);
    }











}
