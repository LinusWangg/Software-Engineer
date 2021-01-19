package com.example.demo.model;

public class Morningclockin {
    private Long clockinTime;

    private String clockinIp;

    private String clockinStuid;

    private String clockinStuschool;

    private String clockinCode;

    private Short clockinSucceed;

    private Float longitude;

    private Float latitude;

    public Morningclockin(Long clockinTime, String clockinIp, String clockinStuid, String clockinStuschool, String clockinCode, Short clockinSucceed, Float longitude, Float latitude) {
        this.clockinTime = clockinTime;
        this.clockinIp = clockinIp;
        this.clockinStuid = clockinStuid;
        this.clockinStuschool = clockinStuschool;
        this.clockinCode = clockinCode;
        this.clockinSucceed = clockinSucceed;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Morningclockin() {
        super();
    }

    public Long getClockinTime() {
        return clockinTime;
    }

    public void setClockinTime(Long clockinTime) {
        this.clockinTime = clockinTime;
    }

    public String getClockinIp() {
        return clockinIp;
    }

    public void setClockinIp(String clockinIp) {
        this.clockinIp = clockinIp == null ? null : clockinIp.trim();
    }

    public String getClockinStuid() {
        return clockinStuid;
    }

    public void setClockinStuid(String clockinStuid) {
        this.clockinStuid = clockinStuid == null ? null : clockinStuid.trim();
    }

    public String getClockinStuschool() {
        return clockinStuschool;
    }

    public void setClockinStuschool(String clockinStuschool) {
        this.clockinStuschool = clockinStuschool == null ? null : clockinStuschool.trim();
    }

    public String getClockinCode() {
        return clockinCode;
    }

    public void setClockinCode(String clockinCode) {
        this.clockinCode = clockinCode == null ? null : clockinCode.trim();
    }

    public Short getClockinSucceed() {
        return clockinSucceed;
    }

    public void setClockinSucceed(Short clockinSucceed) {
        this.clockinSucceed = clockinSucceed;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}