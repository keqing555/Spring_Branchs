package com.ssm.util;

/**
 * 分页工具
 */
public class PageUtil {
    //页码
    private int page;
    //每页条数
    private int rows;
    //每页起始条数
    private int limitStart;

    public PageUtil() {
    }

    public PageUtil(int page, int rows, int limitStart) {
        this.page = page;
        this.rows = rows;
        this.limitStart = limitStart;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }
}
