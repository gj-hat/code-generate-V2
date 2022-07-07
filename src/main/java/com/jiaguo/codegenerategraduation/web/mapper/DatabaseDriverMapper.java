package com.jiaguo.codegenerategraduation.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaguo.codegenerategraduation.web.controller.vo.DatabaseDriverVo;
import com.jiaguo.codegenerategraduation.web.entity.DatabaseDriver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author     ：JiaGuo
  *@emil     ：1520047927@qq.com
 * @date       ：Created in 2022/7/4
 * @description：
 * @modified By：
 * @version:     4.0
 */

public interface DatabaseDriverMapper extends BaseMapper<DatabaseDriver> {


    List<DatabaseDriverVo> selectDbDriverList(@Param("vo") DatabaseDriverVo data);
}
