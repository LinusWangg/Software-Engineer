package com.example.demo.model;

public class Appeal {
    private String appealStuid;

    private String appealSchool;

    private String appealContent;

    private Long appealTime;

    private Integer appealCondition;

    private String appealAdminid;

    public Appeal(String appealStuid, String appealSchool, String appealContent, Long appealTime, Integer appealCondition, String appealAdminid) {
        this.appealStuid = appealStuid;
        this.appealSchool = appealSchool;
        this.appealContent = appealContent;
        this.appealTime = appealTime;
        this.appealCondition = appealCondition;
        this.appealAdminid = appealAdminid;
    }

    public Appeal() {
        super();
    }

    public String getAppealStuid() {
        return appealStuid;
    }

    public void setAppealStuid(String appealStuid) {
        this.appealStuid = appealStuid == null ? null : appealStuid.trim();
    }

    public String getAppealSchool() {
        return appealSchool;
    }

    public void setAppealSchool(String appealSchool) {
        this.appealSchool = appealSchool == null ? null : appealSchool.trim();
    }

    public String getAppealContent() {
        return appealContent;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent == null ? null : appealContent.trim();
    }

    public Long getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(Long appealTime) {
        this.appealTime = appealTime;
    }

    public Integer getAppealCondition() {
        return appealCondition;
    }

    public void setAppealCondition(Integer appealCondition) {
        this.appealCondition = appealCondition;
    }

    public String getAppealAdminid() {
        return appealAdminid;
    }

    public void setAppealAdminid(String appealAdminid) {
        this.appealAdminid = appealAdminid == null ? null : appealAdminid.trim();
    }
}