package com.clsteach.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class teach {
    private Integer teachId;

    private String teachName;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entryDate;

    private String teachIntro;

    private String teachSex;

    public Integer getTeachId() {
        return teachId;
    }

    public void setTeachId(Integer teachId) {
        this.teachId = teachId;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName == null ? null : teachName.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getTeachIntro() {
        return teachIntro;
    }

    public void setTeachIntro(String teachIntro) {
        this.teachIntro = teachIntro == null ? null : teachIntro.trim();
    }

    public String getTeachSex() {
        return teachSex;
    }

    public void setTeachSex(String teachSex) {
        this.teachSex = teachSex == null ? null : teachSex.trim();
    }
}