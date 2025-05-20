package com.sx.guanli.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class PageBean<T> {
    private Long total;
    private List<T> rows;

    public PageBean(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    public PageBean() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
