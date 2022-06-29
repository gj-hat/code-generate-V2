
package com.jiaguo.codegenerategraduation.web.controller;


import com.jiaguo.codegenerategraduation.common.exception.RRException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.dto.SysUserDto;
import com.jiaguo.codegenerategraduation.web.dao.SysUser;
import com.jiaguo.codegenerategraduation.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author JiaGuo
 * @since 2022-06-27 18:42:30
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询所有数据
     *
     * @param params 分页对象
     * @return 所有数据
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public Result selectAll(ReqParams<SysUser> params) {
        return Result.success(this.sysUserService.pageQuery(params));
    }

    /**
     * 新增数据
     *
     * @param sysUserDto 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result insert(@RequestBody @Valid SysUserDto sysUserDto, BindingResult result) {

        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            throw new RRException(msg);
        }

        sysUserDto.setPassword(new BCryptPasswordEncoder().encode(sysUserDto.getPassword()));
        return sysUserService.saveSysUser(sysUserDto);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Result selectOne(@PathVariable Serializable id) {
        return Result.success(this.sysUserService.getById(id));
    }


    /**
     * 修改数据
     *
     * @param sysUserDto 实体对象
     * @return 修改结果
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody @Valid SysUserDto sysUserDto, BindingResult result) {
        if (result.hasErrors()) {
            String msg = result.getFieldError().getDefaultMessage();
            throw new RRException(msg);
        }
        return this.sysUserService.updateUser(sysUserDto);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return Result.success(this.sysUserService.removeByIds(idList));
    }


}

