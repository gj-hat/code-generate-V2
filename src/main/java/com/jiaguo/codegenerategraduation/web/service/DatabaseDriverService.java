package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseDriverVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseDriver;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 数据库驱动表(DatabaseDriver)表服务接口
 *
 * @author JiaGuo
 * @since 2022-07-04 10:44:15
 */
public interface DatabaseDriverService extends IService<DatabaseDriver> {

    IPage<DatabaseDriverVo> pageQuery(ReqParams<DatabaseDriverVo> params);

    DatabaseDriverVo getDbDriverById(int id);

    Boolean saveDbDriver(DatabaseDriverVo databaseDriverVo, MultipartFile fileName);

    Boolean updateDbDriver(DatabaseDriverVo databaseDriverVo);

    Boolean updateDbDriver(DatabaseDriverVo databaseDriverVo, MultipartFile fileName);

    Boolean delDbDriver(List<Integer> idList);
}

