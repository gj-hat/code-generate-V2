package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseDriverVo;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseResourcesVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseResources;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * 数据源管理(DatabaseResources)表服务接口
 *
 * @author JiaGuo
 * @since 2022-07-06 16:39:48
 */
public interface DatabaseResourcesService extends IService<DatabaseResources> {


    IPage<DatabaseResourcesVo> pageQuery(ReqParams<DatabaseResourcesVo> params);

    DatabaseResourcesVo getDbDriverById(int id);

    Boolean saveDbResources(DatabaseResourcesVo databaseResourcesVo);

    Boolean updateDbResources(DatabaseResourcesVo databaseResourcesVo);

    Boolean delDbResources(List<Integer> idList);

    Boolean testDb(DatabaseResourcesVo databaseResourcesVo);
}

