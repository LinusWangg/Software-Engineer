package com.example.demo.model;

public class User {
    private String usercount;

    private String userpassword;

    private String userid;

    private String username;

    private String usertype;

    private String phonenum;

    private String userschool;

    public User(String usercount, String userpassword, String userid, String username, String usertype, String phonenum, String userschool) {
        this.usercount = usercount;
        this.userpassword = userpassword;
        this.userid = userid;
        this.username = username;
        this.usertype = usertype;
        this.phonenum = phonenum;
        this.userschool = userschool;
    }

    public User() {
        super();
    }

    public String getUsercount() {
        return usercount;
    }

    public void setUsercount(String usercount) {
        this.usercount = usercount == null ? null : usercount.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getUserschool() {
        return userschool;
    }

    public void setUserschool(String userschool) {
        this.userschool = userschool == null ? null : userschool.trim();
    }
}