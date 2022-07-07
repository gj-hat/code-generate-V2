package com.jiaguo.codegenerategraduation.web.controller;



import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseDriverVo;
import com.jiaguo.codegenerategraduation.web.service.DatabaseDriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据库驱动表(DatabaseDriver)表控制层
 *
 * @author JiaGuo
 * @since 2022-07-04 10:44:13
 */
@RestController
@RequestMapping("/databaseDriver")
@Api(value = "数据库驱动 ", tags = "数据库驱动")
public class DatabaseDriverController {
    /**
     * 服务对象
     */
    @Resource
    private DatabaseDriverService databaseDriverService;

    /**
     * 分页查询所有数据
     *
     * @param params 分页对象
     * @return 所有数据
     */
    @RequestMapping(value = "/list", method = { RequestMethod.POST})
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    public Result selectAll(ReqParams<DatabaseDriverVo> params) {
        return Result.success(this.databaseDriverService.pageQuery(params));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/id", method = { RequestMethod.POST})
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    public Result selectOne(@RequestBody int id) {
        return Result.success(this.databaseDriverService.getDbDriverById(id));
    }

    /**
     * 新增数据   包含上传文件
     *
     * @param databaseDriverVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result insert(@RequestPart DatabaseDriverVo databaseDriverVo, @RequestPart MultipartFile fileName) {
        return Result.success(this.databaseDriverService.saveDbDriver(databaseDriverVo, fileName));
    }

    /**
     * 修改数据   不包含上传文件
     *
     * @param databaseDriverVo 实体对象
     * @return 修改结果
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result update(@RequestBody DatabaseDriverVo databaseDriverVo) {
        return Result.success(this.databaseDriverService.updateDbDriver(databaseDriverVo));
    }

    /**
     * 修改数据   包含上传文件
     *
     * @param databaseDriverVo 实体对象
     * @return 修改结果
     */
    @RequestMapping(value = "/updateAndFile", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result updateAndFile(@RequestBody DatabaseDriverVo databaseDriverVo, @RequestPart MultipartFile fileName) {
        return Result.success(this.databaseDriverService.updateDbDriver(databaseDriverVo, fileName));
    }


    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    @ApiOperation(value = "删除数据", notes = "删除数据")
    public Result delete(@RequestBody List<Integer> idList) {
        return Result.success(this.databaseDriverService.delDbDriver(idList));
    }






}

