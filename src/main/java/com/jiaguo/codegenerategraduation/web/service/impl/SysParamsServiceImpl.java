package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysParamsVo;
import com.jiaguo.codegenerategraduation.web.entity.SysParams;
import com.jiaguo.codegenerategraduation.web.mapper.SysParamsMapper;
import com.jiaguo.codegenerategraduation.web.service.SysParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统参数(SysParams)表服务实现类
 *
 * @author JiGuo
 * @since 2022-07-07 17:31:14
 */
@Service
public class SysParamsServiceImpl extends ServiceImpl<SysParamsMapper, SysParams> implements SysParamsService {



    @Autowired
    private SysParamsMapper sysParamsMapper;

    @Override
    public IPage<SysParamsVo> pageQuery(ReqParams<SysParamsVo> params) {
        Page<SysParamsVo> sysParamsVoPage = new Page<>();
        sysParamsVoPage.setCurrent(params.getPageNum());
        sysParamsVoPage.setSize(params.getPageSize());
        List<SysParamsVo> sysParamsVos = sysParamsMapper.pageQuery(params.getData());
        sysParamsVoPage.setRecords(sysParamsVos);
        return sysParamsVoPage.setRecords(sysParamsVos);
    }

    @Override
    public Boolean updateParams(SysParamsVo sysParamsVo) {
        SysParams sysParams = new SysParams().setRemark(sysParamsVo.getRemark())
                .setId(sysParamsVo.getId())
                .setKey(sysParamsVo.getKey())
                .setValue(sysParamsVo.getValue());
        return this.updateById(sysParams);
    }


}

