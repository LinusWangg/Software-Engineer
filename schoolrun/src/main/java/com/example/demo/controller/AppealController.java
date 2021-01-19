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

import com.example.demo.model.Appeal;
import com.example.demo.service.AppealService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/appeal")
public class AppealController {

    // 注入mapper类
    @Resource
    private AppealService appealService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="submit",method=RequestMethod.POST,produces="application/json")
    public int submit(
    		@RequestBody HashMap<String, String> map) {
    	String appeal_stuid = map.get("appeal_stuid");
    	String appeal_school = map.get("appeal_stuschool");
    	long appeal_time = Long.parseLong(map.get("appeal_time"));
    	String appeal_content = map.get("appeal_content");
    	int appeal_condition = 0;
    	int flag = appealService.submit(appeal_stuid,appeal_school,appeal_time,appeal_content,appeal_condition);
    	return flag;
    }
    
    @RequestMapping(path="finish",method=RequestMethod.POST,produces="application/json")
    public int finish(
    		@RequestBody HashMap<String, String> map) {
    	String appeal_stuid = map.get("appeal_stuid");
    	String appeal_school = map.get("appeal_stuschool");
    	long appeal_time = Long.parseLong(map.get("appeal_time"));
    	String appeal_adminid = map.get("appeal_adminid");
    	int appeal_condition = 1;
    	int flag = appealService.finish(appeal_stuid,appeal_school,appeal_time,appeal_adminid,appeal_condition);
    	return flag;
    }
}