package com.tongtu.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/26 0026 16:09
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@Entity
public class Terminal {
    private String id;
    private String imei;
    private String number;
    private String model;
    private String actory;
    private String type;
    private String sim;
    private String releaseStatus;
    private String useStatus;
    private String remarks;
    private Boolean rowStatus;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imei")
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    @Column(name = "actory")
    public String getActory() {
        return actory;
    }

    public void setActory(String actory) {
        this.actory = actory;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "sim")
    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    @Basic
    @Column(name = "release_status")
    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    @Basic
    @Column(name = "use_status")
    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "row_status")
    public Boolean getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Boolean rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terminal terminal = (Terminal) o;

        if (rowStatus != terminal.rowStatus) return false;
        if (actory != null ? !actory.equals(terminal.actory) : terminal.actory != null) return false;
        if (id != null ? !id.equals(terminal.id) : terminal.id != null) return false;
        if (imei != null ? !imei.equals(terminal.imei) : terminal.imei != null) return false;
        if (model != null ? !model.equals(terminal.model) : terminal.model != null) return false;
        if (number != null ? !number.equals(terminal.number) : terminal.number != null) return false;
        if (releaseStatus != null ? !releaseStatus.equals(terminal.releaseStatus) : terminal.releaseStatus != null)
            return false;
        if (remarks != null ? !remarks.equals(terminal.remarks) : terminal.remarks != null) return false;
        if (sim != null ? !sim.equals(terminal.sim) : terminal.sim != null) return false;
        if (type != null ? !type.equals(terminal.type) : terminal.type != null) return false;
        if (useStatus != null ? !useStatus.equals(terminal.useStatus) : terminal.useStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (imei != null ? imei.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (actory != null ? actory.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sim != null ? sim.hashCode() : 0);
        result = 31 * result + (releaseStatus != null ? releaseStatus.hashCode() : 0);
        result = 31 * result + (useStatus != null ? useStatus.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (rowStatus ? 1 : 0);
        return result;
    }
}
