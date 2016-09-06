package com.ssm.project.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.ssm.project.util.GUIDUtil;

public class Email {
    private String eId;

    private String eTitle;

    private String eReceive;

    private String eSender;

    private Integer eIsread;

    private Integer eIsdel;

    private Date eReceivetime;

    private String eUpfile;

    private String eContent;

    public String geteId() {
    	if(StringUtils.isBlank(eId)){
    		return GUIDUtil.get();
    	}
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId == null ? null : eId.trim();
    }

    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle == null ? null : eTitle.trim();
    }

    public String geteReceive() {
        return eReceive;
    }

    public void seteReceive(String eReceive) {
        this.eReceive = eReceive == null ? null : eReceive.trim();
    }

    public String geteSender() {
        return eSender;
    }

    public void seteSender(String eSender) {
        this.eSender = eSender == null ? null : eSender.trim();
    }

    public Integer geteIsread() {
        return eIsread;
    }

    public void seteIsread(Integer eIsread) {
        this.eIsread = eIsread;
    }

    public Integer geteIsdel() {
        return eIsdel;
    }

    public void seteIsdel(Integer eIsdel) {
        this.eIsdel = eIsdel;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    public Date geteReceivetime() {
        return eReceivetime;
    }

    public void seteReceivetime(Date eReceivetime) {
        this.eReceivetime = eReceivetime;
    }

    public String geteUpfile() {
        return eUpfile;
    }

    public void seteUpfile(String eUpfile) {
        this.eUpfile = eUpfile == null ? null : eUpfile.trim();
    }

    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent == null ? null : eContent.trim();
    }
}