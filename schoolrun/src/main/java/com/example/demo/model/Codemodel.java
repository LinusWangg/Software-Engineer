package com.example.demo.model;

public class Codemodel {
    private Integer bornMonth;

    private Integer bronDay;

    private Integer bornHour;

    private Integer bornMinute;

    private String bornString;

    private String picAddress;

    public Codemodel(Integer bornMonth, Integer bronDay, Integer bornHour, Integer bornMinute, String bornString, String picAddress) {
        this.bornMonth = bornMonth;
        this.bronDay = bronDay;
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

    public Integer getBronDay() {
        return bronDay;
    }

    public void setBronDay(Integer bronDay) {
        this.bronDay = bronDay;
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