package com.xqls.entity.zxw;

import java.util.Date;

public class samplingrecord {
    private Integer samplId;

    private Integer samplBottid;

    private Integer samplRese;

    private Date sampDate;

    private Integer blockId;

    private Integer equipId;

    public Integer getSamplId() {
        return samplId;
    }

    public void setSamplId(Integer samplId) {
        this.samplId = samplId;
    }

    public Integer getSamplBottid() {
        return samplBottid;
    }

    public void setSamplBottid(Integer samplBottid) {
        this.samplBottid = samplBottid;
    }

    public Integer getSamplRese() {
        return samplRese;
    }

    public void setSamplRese(Integer samplRese) {
        this.samplRese = samplRese;
    }

    public Date getSampDate() {
        return sampDate;
    }

    public void setSampDate(Date sampDate) {
        this.sampDate = sampDate;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getEquipId() {
        return equipId;
    }

    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }
}