package com.example.demo.model;

public class Codemodel {
    private Integer bornTime;

    private String bornString;

    private String picAddress;

    public Codemodel(Integer bornTime, String bornString, String picAddress) {
        this.bornTime = bornTime;
        this.bornString = bornString;
        this.picAddress = picAddress;
    }

    public Codemodel() {
        super();
    }

    public Integer getBornTime() {
        return bornTime;
    }

    public void setBornTime(Integer bornTime) {
        this.bornTime = bornTime;
    }

    public String getBornString() {
        return bornString;
    }

    public void setBornString(String bornString) {
        this.bornString = bornString == null ? null : bornString.trim();
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress == null ? null : picAddress.trim();
    }
}