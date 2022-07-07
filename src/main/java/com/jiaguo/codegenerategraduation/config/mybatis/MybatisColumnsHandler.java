package com.jiaguo.codegenerategraduation.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jiaguo.codegenerategraduation.web.manager.RequestHolder;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/7/6 10:51
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class MybatisColumnsHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());

        this.strictInsertFill(metaObject, "createBy", String.class, RequestHolder.getAccountName());
        this.strictUpdateFill(metaObject, "updateBy", String.class, RequestHolder.getAccountName());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateBy", String.class, RequestHolder.getAccountName());
    }
}
