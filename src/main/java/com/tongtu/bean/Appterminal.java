package com.tongtu.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/6/27 0027 15:41
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@Entity
public class Appterminal {
    private String channelid;
    private String terminalid;
    private String baiduid;
    private String remarks;
    private Boolean rowStatus;

    @Id
    @Column(name = "channelid")
    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    @Basic
    @Column(name = "terminalid")
    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    @Basic
    @Column(name = "baiduid")
    public String getBaiduid() {
        return baiduid;
    }

    public void setBaiduid(String baiduid) {
        this.baiduid = baiduid;
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

        Appterminal that = (Appterminal) o;

        if (baiduid != null ? !baiduid.equals(that.baiduid) : that.baiduid != null) return false;
        if (channelid != null ? !channelid.equals(that.channelid) : that.channelid != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (rowStatus != null ? !rowStatus.equals(that.rowStatus) : that.rowStatus != null) return false;
        if (terminalid != null ? !terminalid.equals(that.terminalid) : that.terminalid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = channelid != null ? channelid.hashCode() : 0;
        result = 31 * result + (terminalid != null ? terminalid.hashCode() : 0);
        result = 31 * result + (baiduid != null ? baiduid.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (rowStatus != null ? rowStatus.hashCode() : 0);
        return result;
    }
}
