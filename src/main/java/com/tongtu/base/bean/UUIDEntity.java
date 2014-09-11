package com.tongtu.base.bean;

import com.tongtu.util.ChinaMeaning;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
public abstract class UUIDEntity implements Serializable {

    protected String id;

    public UUIDEntity() {
        super();
    }

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "com.tongtu.util.UUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", nullable = false, insertable = true, unique = true, updatable = true, length = 36)
    @ChinaMeaning(meaning = "表主键")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
