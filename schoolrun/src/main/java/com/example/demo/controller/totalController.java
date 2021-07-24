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
import com.example.demo.model.total;
import com.example.demo.service.totalService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/total")
public class totalController {

    // 注入mapper类
    @Resource
    private totalService totalService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="getmine",method=RequestMethod.POST)
    public total getmine(
    		@RequestParam HashMap<String, String> map) {
    	String stuid = map.get("stuid");
    	String stuschool = map.get("stuschool");
    	return totalService.getmine(stuid,stuschool);
    }
    
    @RequestMapping(path="getall",method=RequestMethod.POST,produces="application/json")
    public List<total> getall(
    		@RequestBody HashMap<String, String> map) {
    	String stuschool = map.get("stuschool");
    	return totalService.getall(stuschool);
    }
    
}