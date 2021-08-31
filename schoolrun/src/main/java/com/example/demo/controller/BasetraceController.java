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
import com.example.demo.model.Basetrace;
import com.example.demo.service.BasetraceService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/basetrace")
public class BasetraceController {

    // 注入mapper类
    @Resource
    private BasetraceService basetraceService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="writein",method=RequestMethod.POST,produces="application/json")
    public int writein(
    		@RequestBody HashMap<String, String> map) {
    	String school = map.get("school");
    	JSONArray trace = JSONArray.parseArray(map.get("trace"));
    	int flag = basetraceService.writein(school,trace);
    	return flag;
    }
    
    @RequestMapping(path="getall",method=RequestMethod.POST,produces="application/json")
    public List<Basetrace> getall(
    		@RequestBody HashMap<String, String> map){
    	String school = map.get("school");
    	return basetraceService.getall(school);
    }
    
    @RequestMapping(path="get3",method=RequestMethod.POST)
    public List<Basetrace> get3(
    		@RequestParam HashMap<String, String> map){
    	String school = map.get("school");
    	return basetraceService.get3(school);
    }
}