package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Runclockin;
import com.example.demo.service.RunclockinService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/runclockin")
public class RunclockinController {

    // 注入mapper类
    @Resource
    private RunclockinService runclockinService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="clockin",method=RequestMethod.POST,produces="application/json")
    public int clockin(
    		@RequestBody HashMap<String, String> map) {
    	String clockin_stuid = map.get("clockin_stuid");
    	String clockin_stuschool = map.get("clockin_stuschool");
    	long clockin_time = Long.parseLong(map.get("clockin_time"));
    	JSONArray clockin_trace = JSONArray.parseArray(map.get("clockin_trace"));
    	float run_length = Float.parseFloat(map.get("run_length")); 
    	int run_time = Integer.parseInt(map.get("run_time"));
    	String clockin_ip = map.get("clockin_ip");
    	int baseid = Integer.parseInt(map.get("basetraceid"));
    	int flag = runclockinService.clockin(clockin_stuid,clockin_stuschool,clockin_time,clockin_trace,run_length,run_time,clockin_ip,baseid);
    	return flag;
    }
    
}