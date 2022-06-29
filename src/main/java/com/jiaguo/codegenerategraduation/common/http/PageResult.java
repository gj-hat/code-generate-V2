package com.jiaguo.codegenerategraduation.common.http;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.security.DeclareRoles;
import java.util.List;

/**
 * @author ：JiaGuo
 * @emil ：1520047927@qq.com
 * @date ：Created in 2022/6/27 18:46
 * @description：统一请求相应
 * @modified By：
 * @version: 1.0
 */

@Deprecated
public class PageResult {

    // 总记录
    private long total;

    //显示的记录
    private List rows;

    public PageResult() {
    }


    public PageResult(Page page) {
        this.total = page.getTotal();
        this.rows = page.getRecords();
    }

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
