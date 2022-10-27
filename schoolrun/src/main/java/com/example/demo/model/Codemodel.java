package com.example.demo.model;

public class Codemodel {
    private Integer bornMonth;

    private Integer bornDay;

    private Integer bornHour;

    private Integer bornMinute;

    private String bornString;

    private String picAddress;

    public Codemodel(Integer bornMonth, Integer bornDay, Integer bornHour, Integer bornMinute, String bornString, String picAddress) {
        this.bornMonth = bornMonth;
        this.bornDay = bornDay;
        this.bornHour = bornHour;
        this.bornMinute = bornMinute;
        this.bornString = bornString;
        this.picAddress = picAddress;
    }

    public Codemodel() {
        super();
    }

    public Integer getBornMonth() {
        return bornMonth;
    }

    public void setBornMonth(Integer bornMonth) {
        this.bornMonth = bornMonth;
    }

    public Integer getBornDay() {
        return bornDay;
    }

    public void setBornDay(Integer bornDay) {
        this.bornDay = bornDay;
    }

    public Integer getBornHour() {
        return bornHour;
    }

    public void setBornHour(Integer bornHour) {
        this.bornHour = bornHour;
    }

    public Integer getBornMinute() {
        return bornMinute;
    }

    public void setBornMinute(Integer bornMinute) {
        this.bornMinute = bornMinute;
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