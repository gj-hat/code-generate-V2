package com.jiaguo.codegenerategraduation.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysParamsVo;
import com.jiaguo.codegenerategraduation.web.entity.SysParams;


/**
 * 系统参数(SysParams)表服务接口
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:13
 */
public interface SysParamsService extends IService<SysParams> {

    IPage<SysParamsVo> pageQuery(ReqParams<SysParamsVo> params);


    Boolean updateParams(SysParamsVo sysParamsVo);

}

