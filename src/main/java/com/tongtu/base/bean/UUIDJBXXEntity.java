package com.tongtu.base.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tongtu.util.ChinaMeaning;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:13-7-29 上午10:26
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@MappedSuperclass
@XmlTransient
public abstract class UUIDJBXXEntity implements Serializable {
    @XStreamAlias("XMID")
    @XmlElement(name = "XMID", required = true)
    protected String xmid;

    public UUIDJBXXEntity() {
        super();
    }

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.tongtu.util.UUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "xmcode", nullable = false, insertable = true, unique = true, updatable = true, length = 36)
    @ChinaMeaning(meaning = "表主键")
    /**
     * 获取xmid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXmid() {
        return xmid;
    }
    /**
     * 设置xmid属性的值。
     *
     * @param xm_code
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXmid(String xm_code) {
        this.xmid = xm_code;
    }
}
