package com.xqls.entity.zxw;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class operationlog {
    private Integer operId;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operDate;

    private String operInfo;

    private Integer equipId;

    private Integer blockId;

    private Integer userId;
    
    private String operType;

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Date getOperDate() {
        return operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    public String getOperInfo() {
        return operInfo;
    }

    public void setOperInfo(String operInfo) {
        this.operInfo = operInfo == null ? null : operInfo.trim();
    }

    public Integer getEquipId() {
        return equipId;
    }

    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType == null ? null : operType.trim();
	}
}