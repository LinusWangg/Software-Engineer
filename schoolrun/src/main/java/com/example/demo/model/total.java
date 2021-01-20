package com.example.demo.model;

public class total {
    private Integer runTime;

    private Integer morTime;

    private String stuid;

    private String stuschool;

    public total(Integer runTime, Integer morTime, String stuid, String stuschool) {
        this.runTime = runTime;
        this.morTime = morTime;
        this.stuid = stuid;
        this.stuschool = stuschool;
    }

    public total() {
        super();
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public Integer getMorTime() {
        return morTime;
    }

    public void setMorTime(Integer morTime) {
        this.morTime = morTime;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getStuschool() {
        return stuschool;
    }

    public void setStuschool(String stuschool) {
        this.stuschool = stuschool == null ? null : stuschool.trim();
    }
}