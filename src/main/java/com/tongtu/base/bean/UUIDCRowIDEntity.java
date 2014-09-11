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
public abstract class UUIDCRowIDEntity implements Serializable {
    @XStreamAlias("CROWID")
    @XmlElement(name = "CROWID", required = true)
    protected String crowid;

    public UUIDCRowIDEntity() {
        super();
    }

    /**
     * 获取crowid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.tongtu.util.UUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "crowid", nullable = false, insertable = true, unique = true, updatable = true, length = 36)
    @ChinaMeaning(meaning = "表主键")

    public String getCrowid() {
        return crowid;
    }
    /**
     * 设置crowid属性的值。
     *
     * @param crowid
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCrowid(String crowid) {
        this.crowid = crowid;
    }
}
