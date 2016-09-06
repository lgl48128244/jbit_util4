package com.ssm.project.model;

import org.apache.commons.lang3.StringUtils;

import com.ssm.project.util.GUIDUtil;

public class User {
    private String uId;

    private String uName;

    private String uNickname;

    private String uPwd;

    private Integer uSex;

    private String uAge;

    private String uPhone;

    private String uAddr;

    private Integer uRole;

    private Integer uIsread;

    public String getuId() {
    	if(StringUtils.isBlank(uId)){
    		return GUIDUtil.get();
    	}
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge == null ? null : uAge.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuAddr() {
        return uAddr;
    }

    public void setuAddr(String uAddr) {
        this.uAddr = uAddr == null ? null : uAddr.trim();
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    public Integer getuIsread() {
        return uIsread;
    }

    public void setuIsread(Integer uIsread) {
        this.uIsread = uIsread;
    }
}