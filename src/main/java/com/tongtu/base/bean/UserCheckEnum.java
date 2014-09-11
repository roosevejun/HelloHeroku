package com.tongtu.base.bean;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:13-11-12 下午2:09
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public enum UserCheckEnum {
    /**
     * HasLogin 已登陆
     * LOGOUT 已退出登陆
     * NeedLogin 未登陆
     */
    HasLogin("已登陆"),
    LOGOUT("已退出登陆"),
    NotLogin("未登陆");

    private UserCheckEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private final String value;
}
