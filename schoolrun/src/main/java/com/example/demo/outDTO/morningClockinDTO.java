package com.example.demo.outDTO;

import java.util.Date;

public class morningClockinDTO {
    private String clockinTime;

    private String clockinIp;

    private String clockinStuid;

    private String clockinStuschool;

    private String clockinCode;

    private short clockinSucceed;

    private Float longitude;

    private Float latitude;

    private Long timestamp;

    public morningClockinDTO(String clockinTime, String clockinIp, String clockinStuid, String clockinStuschool, String clockinCode, short clockinSucceed, Float longitude, Float latitude, Long timestamp) {
        this.clockinTime = clockinTime;
        this.clockinIp = clockinIp;
        this.clockinStuid = clockinStuid;
        this.clockinStuschool = clockinStuschool;
        this.clockinCode = clockinCode;
        this.clockinSucceed = clockinSucceed;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public String getClockinStuschool() {
        return clockinStuschool;
    }

    public String getClockinTime() {
        return clockinTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setClockinTime(String clockinTime) {
        this.clockinTime = clockinTime;
    }

    public String getClockinIp() {
        return clockinIp;
    }

    public void setClockinIp(String clockinIp) {
        this.clockinIp = clockinIp;
    }

    public String getClockinStuid() {
        return clockinStuid;
    }

    public void setClockinStuid(String clockinStuid) {
        this.clockinStuid = clockinStuid;
    }

    public String getClockinStuschool(String clockinStuschool) {
        return this.clockinStuschool;
    }

    public void setClockinStuschool(String clockinStuschool) {
        this.clockinStuschool = clockinStuschool;
    }

    public String getClockinCode() {
        return clockinCode;
    }

    public void setClockinCode(String clockinCode) {
        this.clockinCode = clockinCode;
    }

    public short getClockinSucceed() {
        return clockinSucceed;
    }

    public void setClockinSucceed(short clockinSucceed) {
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

    public morningClockinDTO() {
        super();
    }


}
