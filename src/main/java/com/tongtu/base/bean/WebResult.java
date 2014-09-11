package com.tongtu.base.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:倪少君
 * 创建时间: 13-3-15上午11:17
 * 修改人：
 * 修改时间:
 *
 * @版本：
 */
@XmlRootElement(name = "result")
@XStreamAlias("Result")
public class WebResult {

    @XStreamAlias("code")
    private String code;
    @XStreamAlias("message")
    private String message;
    @XStreamAlias("data")
    private Object data;

    public WebResult() {
    }

    public Long getId() {
        return 0L;
    }

    /**
     * 构造器
     *
     * @param code    操作码
     * @param message 消息标识
     * @return
     */
    public WebResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取数据内容
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置数据内容
     *
     * @param data 设置传送数据内容
     * @return
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取数据内容
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResultInfo(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public void setResultInfo(String message) {
        //To change body of created methods use File | Settings | File Templates.
        this.message = message;
        this.data = null;
    }
}
