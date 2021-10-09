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
    private int index;

    public PageUtil() {
    }

    public PageUtil(int page, int rows, int index) {
        this.page = page;
        this.rows = rows;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
