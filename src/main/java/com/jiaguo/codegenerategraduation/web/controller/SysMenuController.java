package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;

import com.jiaguo.codegenerategraduation.web.service.impl.SysMenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 11:41
 * @description：系统资源Controller
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/menu")
@Api(value = "系统资源管理  这里只需要查询即可", tags = "系统资源管理")
public class SysMenuController {

    @Autowired
    private SysMenuServiceImpl sysMenuService;


    /**
     * 分页查找
     * @param params
     * @return
     */
    @RequestMapping(value = "/list", method = { RequestMethod.POST})
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    public Result selectAll(ReqParams<SysMenuVo> params) {
        return this.sysMenuService.pageQuery(params);
    }


    @RequestMapping(value = "/listByDefault", method = { RequestMethod.POST})
    @ApiOperation(value = "废弃: 查询当前登录用户资源", notes = "查询当前登录用户资源 这个留业务层去实现")
    @Deprecated
    public Result selectByLoginUser() {

        return null;
    }




    /**
     * 新增数据
     *
     * @param sysUserVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "废弃: 新增数据", notes = "新增数据  这个业务下一版实现 不用实现这个接口")
    @Deprecated
    public Result insert(@RequestBody @Valid SysMenuVo sysUserVo, BindingResult result) {
        return Result.fail("这个业务下一版实现");
    }

    /**
     * 修改数据
     *
     * @param sysUserVo 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "废弃: 修改数据", notes = "修改数据  这个业务下一版实现 不用实现这个接口")
    public Result update(@RequestBody @Valid SysMenuVo sysUserVo, BindingResult result) {
        return Result.fail("这个业务下一版实现");
    }



    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation(value = "废弃: 删除数据", notes = "删除数据  这个业务下一版实现 不用实现这个接口 ")
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    @Deprecated
    public Result delete(@RequestBody List<Long> idList) {
        return Result.fail("这个业务下一版实现");
    }

    /**
     * 通过主键查询数据
     *
     * @param idList 主键
     * @return 单条数据
     */
    @ApiOperation(value = "废弃: 通过主键查询数据", notes = "通过主键查询单条数据  这个业务层实现")
    @RequestMapping(value = "/ids", method = { RequestMethod.POST})
    @Deprecated
    public Result selectByLoginUser(@RequestBody List<Long> idList) {
        return null;

    }





}
