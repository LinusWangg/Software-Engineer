package com.example.demo.model;

import com.alibaba.fastjson.JSONArray;

public class Basetrace {
    private Integer basetraceid;

    private String school ;

    private JSONArray trace;

    public Basetrace(Integer basetraceid, String school, JSONArray trace) {
        this.basetraceid = basetraceid;
        this.school = school;
        this.trace = trace;
    }

    public Basetrace() {
        super();
    }

    public Integer getbasetraceid() {
        return basetraceid;
    }

    public void setbasetraceid(int basetraceid) {
        this.basetraceid = basetraceid;
    }

    public String getschool() {
        return school;
    }

    public void setschool(String school) {
        this.school = school;
    }

    public JSONArray gettrace() {
        return trace;
    }

    public void settrace(JSONArray trace) {
        this.trace = trace;
    }
}