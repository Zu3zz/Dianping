package com.zth.dianping.request;

/**
 * Author: 3zZ.
 * Date: 2019/12/16 8:11 下午
 */
public class PageQuery {
    private Integer page = 1;
    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
