package com.ssm.project.model;

import org.apache.commons.lang3.StringUtils;

import com.ssm.project.util.GUIDUtil;

public class Vacation {
    private String vId;

    private String vName;

    private String vStarttime;

    private String vEndtime;

    private String vDays;

    private String vReason;

    private String vChecker;

    private Integer vState;

    public String getvId() {
    	if(StringUtils.isBlank(vId)){
    		return GUIDUtil.get();
    	}
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId == null ? null : vId.trim();
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public String getvStarttime() {
        return vStarttime;
    }

    public void setvStarttime(String vStarttime) {
        this.vStarttime = vStarttime == null ? null : vStarttime.trim();
    }

    public String getvEndtime() {
        return vEndtime;
    }

    public void setvEndtime(String vEndtime) {
        this.vEndtime = vEndtime == null ? null : vEndtime.trim();
    }

    public String getvDays() {
        return vDays;
    }

    public void setvDays(String vDays) {
        this.vDays = vDays == null ? null : vDays.trim();
    }

    public String getvReason() {
        return vReason;
    }

    public void setvReason(String vReason) {
        this.vReason = vReason == null ? null : vReason.trim();
    }

    public String getvChecker() {
        return vChecker;
    }

    public void setvChecker(String vChecker) {
        this.vChecker = vChecker == null ? null : vChecker.trim();
    }

    public Integer getvState() {
        return vState;
    }

    public void setvState(Integer vState) {
        this.vState = vState;
    }
}