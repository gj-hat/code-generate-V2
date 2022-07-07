package com.jiaguo.codegenerategraduation.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaguo.codegenerategraduation.common.exception.DatabaseException;
import com.jiaguo.codegenerategraduation.common.http.ReqParams;
import com.jiaguo.codegenerategraduation.common.http.Result;
import com.jiaguo.codegenerategraduation.web.controller.vo.SysMenuVo;
import com.jiaguo.codegenerategraduation.web.mapper.SysMenuMapper;
import com.jiaguo.codegenerategraduation.web.entity.SysMenu;
import com.jiaguo.codegenerategraduation.web.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/30 18:16
 * @description：系统菜单资源
 * @modified By：
 * @version: 1.0
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 分页查找
     *
     * @param params
     * @return
     */
    @Override
    public Result pageQuery(ReqParams<SysMenuVo> params) {
        IPage<SysMenuVo> page = new Page<>(params.getPageNum(), params.getPageSize());
        IPage<SysMenuVo> sysUserVoIPage;
        try {
            sysUserVoIPage = sysMenuMapper.pageQueryMenu(page, params.getData());

        } catch (DatabaseException e) {
            logger.error("sysMenuMapper.pageQuery 查询失败", e);
            return Result.fail("sysMenuMapper.pageQuery 查询失败");
        }
        return Result.success(sysUserVoIPage);
    }


    /**
     * 根据id集合查询所有菜单
     *
     * @param ids
     * @return
     */
    @Override
    public List<SysMenuVo> selectByLoginUser(List<Integer> ids) {
        List<SysMenuVo> sysMenuVos;
        try {
            sysMenuVos = sysMenuMapper.selectByLoginUser(ids);

        } catch (DatabaseException e) {
            logger.error("sysMenuMapper.selectByLoginUser 查询失败", e);
            return null;
        }
        return sysMenuVos;
    }

    /**
     * 根据菜单id  查询菜单实体
     *
     * @param id
     * @return
     */
    @Override
    public SysMenuVo selectListByMenuId( int id) {

        SysMenuVo sysMenuVo = sysMenuMapper.selectListByMenuId(id);

        return sysMenuVo;
    }
}

