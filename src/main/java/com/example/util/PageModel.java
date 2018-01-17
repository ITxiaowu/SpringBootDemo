package com.example.util;

import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * @param <E>
 */
public class PageModel<E> {
    // 结果集
    private List<E> list;
    // 数据总条数
    private int totalCount;
    // 总页数
    private int totalPage;
    // 每页显示条数
    private int pageSize = 5;
    // 当前页
    private int pageNo;
    // 当前的数据位置（应用于mysql的limit只能是常量的情况）
    private int thisNo;
    //查询条件，这几个条件是 && 的关系
    private Map<String, Object> searchMap;

    public Map<String, Object> getSearchMap() {
        return searchMap;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return(totalCount + pageSize-1)/pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getThisNo() {
        return (pageNo-1)*pageSize;
    }

    public void setThisNo(int thisNo) {
        this.thisNo = thisNo;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }
}
