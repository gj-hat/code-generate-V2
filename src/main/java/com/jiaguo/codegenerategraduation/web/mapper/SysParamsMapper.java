package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysParamsVo;
import com.jiaguo.codegenerategraduation.web.entity.SysParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统参数(SysParams)表数据库访问层
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:12
 */
public interface SysParamsMapper extends BaseMapper<SysParams> {

    List<SysParamsVo> pageQuery(@Param("vo") SysParamsVo data);
}

