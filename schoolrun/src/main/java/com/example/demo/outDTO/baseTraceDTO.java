package com.example.demo.outDTO;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class baseTraceDTO {

    private Integer basetraceid;

    private String school ;

    private List<pointDTO> trace;

    public baseTraceDTO(Integer basetraceid, String school, List<pointDTO> trace) {
        this.basetraceid = basetraceid;
        this.school = school;
        this.trace = trace;
    }

    public baseTraceDTO() {
        super();
    }

    public Integer getBasetraceid() {
        return basetraceid;
    }

    public void setBasetraceid(Integer basetraceid) {
        this.basetraceid = basetraceid;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<pointDTO> getTrace() {
        return trace;
    }

    public void setTrace(List<pointDTO> trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "baseTraceDTO{" +
                "basetraceid=" + basetraceid +
                ", school='" + school + '\'' +
                ", trace=" + trace.toString() +
                '}';
    }
}
