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
import java.util.List;

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
    
    @RequestMapping(path="regist",method=RequestMethod.POST)
    public int registUser(
    		@RequestParam HashMap<String, String> map) {
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	String userid = map.get("userid");
    	String username = map.get("username");
    	String phonenum = map.get("phonenum");
    	String userschool = map.get("userschool");
    	int flag = userService.registUser(usercount,userpassword,userid,username,phonenum,userschool);
    	return flag;
    }
    
    @RequestMapping(path="login",method=RequestMethod.POST)
    public User loginUser(
    		@RequestParam HashMap<String, String> map) {
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	return userService.loginUser(usercount,userpassword);
    }

    @RequestMapping(path="modify",method=RequestMethod.POST)
    public int modifyUser(
    		@RequestParam HashMap<String, String> map){
    	String usercount = map.get("usercount");
    	String userpassword = map.get("userpassword");
    	String modify_userpassword = map.get("modify_password");
    	int flag = userService.modifyUser(usercount,userpassword,modify_userpassword);
    	return flag;
    }

    @RequestMapping(path="adminLogin", method = RequestMethod.POST, produces="application/json")
	public User adminLogin(
			@RequestBody HashMap<String, String> map){
		String usercount = map.get("usercount");
		String userpassword = map.get("userpassword");
		return userService.loginUser(usercount,userpassword);
	}

	@RequestMapping(path="getall", method = RequestMethod.POST, produces="application/json")
	public List<User> getall(
			@RequestBody HashMap<String, String> map){
		int page = Integer.parseInt(map.get("page"));
		String school = map.get("school");
		return userService.getall(school, page);
	}

	@RequestMapping(path="adminModify",method=RequestMethod.POST, produces="application/json")
	public int adminModifyUser(
			@RequestBody HashMap<String, String> map){
		String usercount = map.get("usercount");
		String username = map.get("username");
		String userid = map.get("userid");
		int flag = userService.updateUser(usercount, userid, username);
		return flag;
	}
}