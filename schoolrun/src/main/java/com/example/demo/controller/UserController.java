package com.example.demo.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    // 注入mapper类
    @Resource
    private UserService userService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="regist",method=RequestMethod.POST,produces="application/json")
    public int registUser(
    		@RequestBody HashMap<String, String> map) {
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	int flag = userService.registUser(usercount,userpassword);
    	return flag;
    }
    
    @RequestMapping(path="update",method=RequestMethod.POST,produces="application/json")
    public int updateUser(
    		@RequestBody HashMap<String, String> map) {
    	String usercount = map.get("usercount");
    	String userid = map.get("userid");
    	String username = map.get("username");
    	String phonenum = map.get("phonenum");
    	String userschool = map.get("userschool");
    	int flag = userService.updateUser(usercount,userid,username,phonenum,userschool);
    	return flag;
    }
    
    @RequestMapping(path="login",method=RequestMethod.POST,produces="application/json")
    public int loginUser(
    		@RequestBody HashMap<String, String> map) {
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	int flag = userService.loginUser(usercount,userpassword);
    	return flag;
    }

    @RequestMapping(path="modify",method=RequestMethod.POST,produces="application/json")
    public int modifyUser(
    		@RequestBody HashMap<String, String> map){
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	String modify_userpassword = map.get("modify_password");
    	int flag = userService.modifyUser(usercount,userpassword,modify_userpassword);
    	return flag;
    }
}