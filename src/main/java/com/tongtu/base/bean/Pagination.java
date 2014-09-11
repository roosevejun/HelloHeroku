package com.tongtu.base.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:倪少君
 * 创建时间: 13-4-7下午1:27
 * 修改人：
 * 修改时间:
 *
 * @版本：
 */
@XStreamAlias("Result")
public class Pagination<T> {
    @JsonProperty("rows")
    @XStreamAlias("rows")
    protected List<T> rows;
    @XStreamAlias("total")
    protected Long total;
    @XStreamAlias("colmodel")
    protected List<T> colmodel;

    public Pagination(List<T> rows, Long total) {
        this.rows = rows;
        this.total = total;
        this.colmodel=new ArrayList<T>();
    }

    public List<T> getRows() {
        if (rows == null) {
            rows = new ArrayList<T>();
        }
        return rows;
    }

    public Long getTotal() {
        return total;
    }
    public List<T> getColmodel() {
        if (colmodel == null) {
            colmodel = new ArrayList<T>();
        }
        return colmodel;
    }
}
