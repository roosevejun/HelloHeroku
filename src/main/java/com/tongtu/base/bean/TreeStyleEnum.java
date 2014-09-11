package com.tongtu.base.bean;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:倪少君
 * 创建时间: 13-4-22下午5:07
 * 修改人：
 * 修改时间:
 *
 * @版本：
 */
public enum TreeStyleEnum {
    /**
     * jg 组织
     * bm 部门
     * haad 根
     */
    jg("parenticon"), bm("leaf"), haad("hoemparenticon"),ry("node");

    private TreeStyleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private final String value;
}
