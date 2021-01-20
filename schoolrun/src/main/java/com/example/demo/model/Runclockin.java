package com.example.demo.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Runclockin {
    private Long clockinTime;

    private String clockinIp;

    private String clockinStuid;

    private String clockinStuschool;

    private JSONArray clockinTrace;

    private Short clockinSucceed;
    
    private float runLength;
    
    private int runTime;
    
    private int baseid;
    
    private float dtw;

    public Runclockin(Long clockinTime, String clockinIp, String clockinStuid, String clockinStuschool, JSONArray clockinTrace, Short clockinSucceed
    		, float runLength, int runTime, int baseid, float dtw) {
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
    }

    public Runclockin() {
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
    
    public float getRunLength() {
        return runLength;
    }
    
    public int getRunTime() {
        return runTime;
    }

    public void setClockinStuschool(String clockinStuschool) {
        this.clockinStuschool = clockinStuschool == null ? null : clockinStuschool.trim();
    }

    public JSONArray getClockinTrace() {
        return clockinTrace;
    }

    public void setClockinTrace(JSONArray clockinTrace) {
        this.clockinTrace = clockinTrace == null ? null : clockinTrace;
    }

    public Short getClockinSucceed() {
        return clockinSucceed;
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
    
    public void setRunLength(float runLength) {
        this.runLength = runLength;
    }
    
    public void setClockinSucceed(Short clockinSucceed) {
        this.clockinSucceed = clockinSucceed;
    }
}