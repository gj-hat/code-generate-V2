package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiaguo.codegenerategraduation.common.db.ConnectDB;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseResourcesVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseDriver;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseResources;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.DatabaseDriverMapper;
import com.jiaguo.codegenerategraduation.web.mapper.DatabaseResourcesMapper;
import com.jiaguo.codegenerategraduation.web.service.DatabaseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 数据源管理(DatabaseResources)表服务实现类
 *
 * @author JiaGuo
 * @since 2022-07-06 16:39:48
 */
@Service
public class DatabaseResourcesServiceImpl extends ServiceImpl<DatabaseResourcesMapper, DatabaseResources> implements DatabaseResourcesService {


    @Autowired
    private DatabaseResourcesMapper databaseResourcesMapper;
    @Autowired
    private DatabaseDriverMapper databaseDriverMapper;

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public IPage<DatabaseResourcesVo> pageQuery(ReqParams<DatabaseResourcesVo> params) {
        Page<DatabaseResourcesVo> databaseResourcesPage = new Page<>();
        databaseResourcesPage.setCurrent(params.getPageNum());
        databaseResourcesPage.setSize(params.getPageSize());
        List<DatabaseResourcesVo> databaseResourcesVos = databaseResourcesMapper.pageQuery(params.getData());
        databaseResourcesPage.setRecords(databaseResourcesVos);
        return databaseResourcesPage;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public DatabaseResourcesVo getDbDriverById(int id) {
        QueryWrapper<DatabaseResources> qw = new QueryWrapper<>();
        qw.eq("id", id);
        DatabaseResources databaseResources = databaseResourcesMapper.selectOne(qw);
        DatabaseDriver driver = databaseDriverMapper.selectById(databaseResources.getDriverId());

        return new DatabaseResourcesVo()
                .setId(databaseResources.getId())
                .setName(databaseResources.getName())
                .setRemark(databaseResources.getRemark())
                .setHost(databaseResources.getHost())
                .setUsername(databaseResources.getUsername())
                .setPassword(databaseResources.getPassword())
                .setPort(databaseResources.getPort())
                .setDatabaseName(databaseResources.getDatabaseName())
                .setDriverId(databaseResources.getDriverId())
                .setDatabaseType(databaseResources.getDatabaseType())
                .setDriverName(driver.getName())
                .setDriverUrl(driver.getUrl());
    }

    /**
     * 新增
     *
     * @param databaseResourcesVo
     * @return
     */
    @Override
    public Boolean saveDbResources(DatabaseResourcesVo databaseResourcesVo) {
        return this.save(new DatabaseResources()
                .setName(databaseResourcesVo.getName())
                .setRemark(databaseResourcesVo.getRemark())
                .setHost(databaseResourcesVo.getHost())
                .setUsername(databaseResourcesVo.getUsername())
                .setPassword(databaseResourcesVo.getPassword())
                .setPort(databaseResourcesVo.getPort())
                .setDatabaseName(databaseResourcesVo.getDatabaseName())
                .setDatabaseType(databaseResourcesVo.getDatabaseType())
                .setDriverId(databaseResourcesVo.getDriverId())
                .setDelFlag(0)
        );
    }

    /**
     * 修改
     *
     * @param databaseResourcesVo
     * @return
     */
    @Override
    public Boolean updateDbResources(DatabaseResourcesVo databaseResourcesVo) {
        return this.updateById(new DatabaseResources()
                .setId(databaseResourcesVo.getId())
                .setName(databaseResourcesVo.getName())
                .setRemark(databaseResourcesVo.getRemark())
                .setUsername(databaseResourcesVo.getUsername())
                .setPassword(databaseResourcesVo.getPassword())
                .setHost(databaseResourcesVo.getHost())
                .setPort(databaseResourcesVo.getPort())
                .setDatabaseName(databaseResourcesVo.getDatabaseName())
                .setDatabaseType(databaseResourcesVo.getDatabaseType())
                .setDriverId(databaseResourcesVo.getDriverId()));
    }

    /**
     * 删除
     *
     * @param idList
     * @return
     */
    @Override
    public Boolean delDbResources(List<Integer> idList) {
        return this.update(new DatabaseResources()
                        .setUpdateBy(RequestHolder.getAccountName())
                        .setUpdateTime(new Date())
                        .setDelFlag(1),
                new QueryWrapper<DatabaseResources>()
                        .in("id", idList));
    }


    @Override
    public Boolean testDb(DatabaseResourcesVo databaseResourcesVo) {
        QueryWrapper<DatabaseDriver> databaseDriverQueryWrapper = new QueryWrapper<>();
        databaseDriverQueryWrapper.eq("id", databaseResourcesVo.getDriverId());
        databaseDriverQueryWrapper.eq("del_flag", 0);
        DatabaseDriver databaseDriver = databaseDriverMapper.selectOne(databaseDriverQueryWrapper);
        databaseResourcesVo.setDriverUrl(databaseDriver.getUrl());
        return ConnectDB.testConnectDB(databaseResourcesVo);
    }
}























