package com.jiaguo.codegenerategraduation.web.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysParamsVo;
import com.jiaguo.codegenerategraduation.web.service.SysParamsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统参数(SysParams)表控制层
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:10
 */
@RestController
@RequestMapping("/sysParams")
public class SysParamsController  {
    /**
     * 服务对象
     */
    @Resource
    private SysParamsService sysParamsService;

    /**
     * 分页查询所有数据
     *
     * @param params 分页对象
     * @return 所有数据
     */
    @RequestMapping(value = "/list", method = { RequestMethod.POST})
    @ApiOperation(value = "分页查询系统参数", notes = "分页查询系统参数")
    public Result selectAll(ReqParams<SysParamsVo> params) {
        return Result.success(this.sysParamsService.pageQuery(params));
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
    public Result selectOne(@RequestBody int id) {
        return Result.success("废弃");
    }

    /**
     * 新增数据
     *
     * @param sysParamsVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @Deprecated
    public Result insert(@RequestBody SysParamsVo sysParamsVo) {
        return Result.success("废弃");
    }

    /**
     * 修改数据
     *
     * @param sysParamsVo 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据", notes = "修改系统参数")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody SysParamsVo sysParamsVo) {
        return Result.success(this.sysParamsService.updateParams(sysParamsVo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    @Deprecated
    public Result delete(@RequestBody List<Long> idList) {
        return Result.success("废弃");
    }
}

