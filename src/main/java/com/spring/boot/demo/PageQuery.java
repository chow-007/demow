package com.spring.boot.demo;

import com.spring.boot.demo.TimeQuery;

/**
 * @Auther: ZJS
 * @Date: 2018-11-14 16:45
 * @Description:  分页查询实体
 */
public class PageQuery extends TimeQuery {

    /**
     * 分页数量
     */
    private Integer pageSize = 20;

    /**
     * 分页页数
     */
    private Integer pageNum = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

}
