package com.jiaguo.codegenerategraduation.web.controller;

import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseResourcesVo;
import com.jiaguo.codegenerategraduation.web.service.DatabaseResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据源管理(DatabaseResources)表控制层
 *
 * @author JiGuo
 * @since 2022-07-06 16:39:48
 */
@RestController
@RequestMapping("/databaseResources")
@Api(value = "数据源管理", tags = "数据源管理")
public class DatabaseResourcesController {
    /**
     * 服务对象
     */
    @Autowired
    private DatabaseResourcesService databaseResourcesService;

    /**
     * 分页查询所有数据
     *
     * @param params              分页查询对象
     * @return 所有数据
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiOperation(value = "分页查询所有数据", notes = "分页查询所有数据")
    public Result selectAll(ReqParams<DatabaseResourcesVo> params) {
        return Result.success(databaseResourcesService.pageQuery(params));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/id", method = {RequestMethod.POST})
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")

    public Result selectOne(@RequestBody int id) {
        return Result.success(this.databaseResourcesService.getDbDriverById(id));
    }

    /**
     * 新增数据
     *
     * @param databaseResourcesVo 实体对象
     * @return 新增结果
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result insert(@RequestBody DatabaseResourcesVo databaseResourcesVo) {
        return Result.success(this.databaseResourcesService.saveDbResources(databaseResourcesVo));
    }

    /**
     * 修改数据
     *
     * @param databaseResourcesVo 实体对象
     * @return 修改结果
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result update(@RequestBody DatabaseResourcesVo databaseResourcesVo) {
        return Result.success(this.databaseResourcesService.updateDbResources(databaseResourcesVo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @RequestMapping(value = "/updateAndFile", method = {RequestMethod.POST})
    @ApiOperation(value = "新增数据", notes = "新增数据  包含上传文件")
    public Result delete(@RequestBody List<Integer> idList) {
        return Result.success(this.databaseResourcesService.delDbResources(idList));
    }

    @RequestMapping(value = "/testDb", method = {RequestMethod.POST})
    @ApiOperation(value = "测试数据库连接", notes = "测试数据库连接")
    public Result testDb(@RequestBody DatabaseResourcesVo databaseResourcesVo) {
        return Result.success(this.databaseResourcesService.testDb(databaseResourcesVo));
    }

}
