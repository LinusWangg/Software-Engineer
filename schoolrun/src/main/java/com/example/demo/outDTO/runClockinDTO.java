package com.example.demo.outDTO;

import com.alibaba.fastjson.JSONArray;

public class runClockinDTO {

    private String clockinTime;

    private String clockinIp;

    private String clockinStuid;

    private String clockinStuschool;

    private JSONArray clockinTrace;

    private Short clockinSucceed;

    private float runLength;

    private int runTime;

    private int baseid;

    private float dtw;

    private Long timestamp;

    public runClockinDTO(String clockinTime, String clockinIp, String clockinStuid, String clockinStuschool, JSONArray clockinTrace, Short clockinSucceed
            , float runLength, int runTime, int baseid, float dtw, long timestamp) {
        this.clockinTime = clockinTime;
        this.clockinIp = clockinIp;
        this.clockinStuid = clockinStuid;
        this.clockinStuschool = clockinStuschool;
        this.clockinTrace = clockinTrace;
        this.clockinSucceed = clockinSucceed;
        this.runLength = runLength;
        this.runTime = runTime;
        this.baseid = baseid;
        this.dtw = dtw;
        this.timestamp = timestamp;
    }

    public runClockinDTO() {
        super();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getClockinTime() {
        return clockinTime;
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

    public String getClockinStuschool() {
        return clockinStuschool;
    }

    public void setClockinStuschool(String clockinStuschool) {
        this.clockinStuschool = clockinStuschool;
    }

    public JSONArray getClockinTrace() {
        return clockinTrace;
    }

    public void setClockinTrace(JSONArray clockinTrace) {
        this.clockinTrace = clockinTrace;
    }

    public Short getClockinSucceed() {
        return clockinSucceed;
    }

    public void setClockinSucceed(Short clockinSucceed) {
        this.clockinSucceed = clockinSucceed;
    }

    public float getRunLength() {
        return runLength;
    }

    public void setRunLength(float runLength) {
        this.runLength = runLength;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getBaseid() {
        return baseid;
    }

    public void setBaseid(int baseid) {
        this.baseid = baseid;
    }

    public float getDtw() {
        return dtw;
    }

    public void setDtw(float dtw) {
        this.dtw = dtw;
    }
}
