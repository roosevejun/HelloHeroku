package com.tongtu.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/5/16 0016 15:46
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@Entity
@XmlRootElement
public class App implements Serializable {
    private String baiduid;
    private String name;
    private String model;
    private String release;
    private String secretkey;
    private String apikey;
    private String remarks;

    @Id
    @Column(name = "baiduid")
    public String getBaiduid() {
        return baiduid;
    }

    public void setBaiduid(String baiduid) {
        this.baiduid = baiduid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "release")
    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Basic
    @Column(name = "secretkey")
    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    @Basic
    @Column(name = "apikey")
    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        App app = (App) o;

        if (apikey != null ? !apikey.equals(app.apikey) : app.apikey != null) return false;
        if (baiduid != null ? !baiduid.equals(app.baiduid) : app.baiduid != null) return false;
        if (model != null ? !model.equals(app.model) : app.model != null) return false;
        if (name != null ? !name.equals(app.name) : app.name != null) return false;
        if (release != null ? !release.equals(app.release) : app.release != null) return false;
        if (remarks != null ? !remarks.equals(app.remarks) : app.remarks != null) return false;
        if (secretkey != null ? !secretkey.equals(app.secretkey) : app.secretkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = baiduid != null ? baiduid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (release != null ? release.hashCode() : 0);
        result = 31 * result + (secretkey != null ? secretkey.hashCode() : 0);
        result = 31 * result + (apikey != null ? apikey.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
