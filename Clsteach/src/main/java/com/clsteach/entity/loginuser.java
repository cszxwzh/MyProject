package com.clsteach.entity;

public class loginuser {
    private Integer logId;

    private String logName;

    private String logPsw;

    private Integer logType;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public String getLogPsw() {
        return logPsw;
    }

    public void setLogPsw(String logPsw) {
        this.logPsw = logPsw == null ? null : logPsw.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }
}