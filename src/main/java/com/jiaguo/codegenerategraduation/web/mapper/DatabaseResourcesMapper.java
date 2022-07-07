package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseResourcesVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseResources;

import java.util.List;

/**
 * 数据源管理(DatabaseResources)表数据库访问层
 *
 * @author JiaGuo
 * @since 2022-07-06 16:39:48
 */
public interface DatabaseResourcesMapper extends BaseMapper<DatabaseResources> {

    List<DatabaseResourcesVo> pageQuery(DatabaseResourcesVo data);
}

