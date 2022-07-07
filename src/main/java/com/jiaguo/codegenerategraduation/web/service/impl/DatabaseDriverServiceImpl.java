package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.Constants;
import com.jiaguo.codegenerategraduation.common.exception.FileException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.util.FileOperation;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseDriverVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseDriver;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import com.jiaguo.codegenerategraduation.web.mapper.DatabaseDriverMapper;
import com.jiaguo.codegenerategraduation.web.service.DatabaseDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 数据库驱动表(DatabaseDriver)表服务实现类
 *
 * @author JiaGuo
 * @since 2022-07-04 10:44:15
 */
@Service
public class DatabaseDriverServiceImpl extends ServiceImpl<DatabaseDriverMapper, DatabaseDriver> implements DatabaseDriverService {
    // log
    private static final Logger logger = LoggerFactory.getLogger(DatabaseDriverServiceImpl.class);
    @Autowired
    private DatabaseDriverMapper databaseDriverMapper;


    /**
     * 分页查找
     *
     * @param params
     * @return
     */
    @Override
    public IPage<DatabaseDriverVo> pageQuery(ReqParams<DatabaseDriverVo> params) {
        IPage<DatabaseDriverVo> vo = new Page<>();
        vo.setCurrent(params.getPageNum());
        vo.setSize(params.getPageSize());
        List<DatabaseDriverVo> databaseDriverVos = databaseDriverMapper.selectDbDriverList(params.getData());
        vo.setRecords(databaseDriverVos);
        return vo;
    }


    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    @Override
    public DatabaseDriverVo getDbDriverById(int id) {
        DatabaseDriver driver = databaseDriverMapper.selectOne(new QueryWrapper<DatabaseDriver>().eq("id", id));
        return new DatabaseDriverVo()
                .setId(driver.getId())
                .setName(driver.getName())
                .setRemark(driver.getRemark())
                .setUrl(driver.getUrl());
//                .setCreateTime(driver.getCreateTime())
//                .setCreateBy(driver.getCreateBy())
//                .setUpdateTime(driver.getUpdateTime())
//                .setUpdateBy(driver.getUpdateBy());
    }


    /**
     * 保存数据库驱动
     *
     * @param databaseDriverVo
     * @return
     */
    @Override
    public Boolean saveDbDriver(DatabaseDriverVo databaseDriverVo, MultipartFile fileName) {
        String urlPath = Constants.DRIVER_PATH_PREFIX + fileName.getOriginalFilename();
        File mkdirs = new File(urlPath);
        try {
            // 如果urlPath不存在则创建
            if (!mkdirs.exists()) {
                mkdirs.mkdirs();
            }

            fileName.transferTo(mkdirs);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("保存数据库驱动失败：" + e.getMessage());
            throw new FileException(500, "文件写入失败");
        }

        return this.save(new DatabaseDriver()
                .setName(databaseDriverVo.getName())
                .setRemark(databaseDriverVo.getRemark())
                .setUrl(fileName.getOriginalFilename())
//                .setCreateTime(new Date())
//                .setCreateBy(RequestHolder.getAccountName())
//                .setUpdateTime(new Date())
//                .setUpdateBy(RequestHolder.getAccountName())
                .setDelFlag(0));
    }

    /**
     * 更新数据库驱动 不包含文件
     *
     * @param databaseDriverVo
     * @return
     */
    @Override
    public Boolean updateDbDriver(DatabaseDriverVo databaseDriverVo) {
        return this.saveOrUpdate(new DatabaseDriver()
                .setId(databaseDriverVo.getId())
                .setName(databaseDriverVo.getName())
                .setRemark(databaseDriverVo.getRemark()));
//                .setUpdateTime(new Date())
//                .setUpdateBy(RequestHolder.getAccountName()));
    }

    /**
     * 更新数据库驱动 包含文件
     *
     * @param databaseDriverVo
     * @param fileName
     * @return
     */
    @Override
    public Boolean updateDbDriver(DatabaseDriverVo databaseDriverVo, MultipartFile fileName) {
        FileOperation.deleteFile(databaseDriverVo.getUrl());
        String urlPath = Constants.DRIVER_PATH_PREFIX + fileName.getOriginalFilename();
        File mkdirs = new File(urlPath);
        try {
            fileName.transferTo(mkdirs);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("保存数据库驱动失败：" + e.getMessage());
            throw new FileException(500, "文件写入失败");
        }

        return this.saveOrUpdate(new DatabaseDriver()
                .setId(databaseDriverVo.getId())
                .setName(databaseDriverVo.getName())
                .setRemark(databaseDriverVo.getRemark())
                .setUrl(urlPath));
//                .setUpdateTime(new Date())
//                .setUpdateBy(RequestHolder.getAccountName()));
    }

    /**
     * 删除数据库驱动
     *
     * @param idList
     * @return
     */
    @Override
    public Boolean delDbDriver(List<Integer> idList) {
        idList.forEach(id -> {
            // 物理删除文件
            FileOperation.deleteFile(databaseDriverMapper.selectOne(
                    new QueryWrapper<DatabaseDriver>()
                            .eq("id", id))
                    .getUrl());
            // 逻辑删除数据库驱动
            this.update(new UpdateWrapper<DatabaseDriver>()
                    .eq("id", id)
                    .set("del_flag", 1)
                    .set("update_time", new Date())
                    .set("update_by", RequestHolder.getAccountName()));
        });
        return true;
    }
}

































