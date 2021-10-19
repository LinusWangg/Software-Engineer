package com.example.demo.outDTO;

public class appealDTO {

    private String appealStuid;

    private String appealSchool;

    private String appealContent;

    private String appealTime;

    private Integer appealCondition;

    private String appealAdminid;

    public appealDTO(String appealStuid, String appealSchool, String appealContent, String appealTime, Integer appealCondition, String appealAdminid) {
        this.appealStuid = appealStuid;
        this.appealSchool = appealSchool;
        this.appealContent = appealContent;
        this.appealTime = appealTime;
        this.appealCondition = appealCondition;
        this.appealAdminid = appealAdminid;
    }

    public appealDTO() {
        super();
    }

    public String getAppealStuid() {
        return appealStuid;
    }

    public void setAppealStuid(String appealStuid) {
        this.appealStuid = appealStuid;
    }

    public String getAppealSchool() {
        return appealSchool;
    }

    public void setAppealSchool(String appealSchool) {
        this.appealSchool = appealSchool;
    }

    public String getAppealContent() {
        return appealContent;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent;
    }

    public String getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(String appealTime) {
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
        this.appealAdminid = appealAdminid;
    }
}
