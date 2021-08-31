package com.example.demo.service.impl;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;

@Service("userService")
public class UserServiceImpl implements UserService {

    // 注入mapper类
    @Resource
    private UserMapper userMapper;
    
    @Override
    public int registUser(String usercount,String userpassword,String userid,String username,String phonenum,String userschool) {
    	User user = userMapper.findbycount(usercount);
    	if(user == null) {
    		User temp = new User();
    		temp.setUsercount(usercount);
    		temp.setUserpassword(userpassword);
    		temp.setPhonenum(phonenum);
    		temp.setUserid(userid);
    		temp.setUserschool(userschool);
    		temp.setUsername(username);
    		temp.setUsertype("S");
    		userMapper.insertSelective(temp);
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
    
    @Override
    public User updateUser(String usercount,String userid,String username,String phonenum,String userschool) {
    	userMapper.updateUser(usercount,userid,username,"stu",phonenum,userschool);
    	User user = new User();
    	user.setPhonenum(phonenum);
    	user.setUserid(userid);
    	user.setUserschool(userschool);
    	user.setUsername(username);
    	return user;
    }
    
    @Override
    public User loginUser(String usercount,String userpassword) {
    	User user = userMapper.findbycount(usercount);
    	if(user == null) {
    		return null; //0-无此用户
    	}
    	if(!user.getUserpassword().equals(userpassword)) {
    		return null;//1-密码错误
    	}
    	user.setUserpassword("AccessDined!");
    	return user;//2-登陆成功
    }
    
    @Override
    public int modifyUser(String usercount,String userpassword,String modify_userpassword) {
    	User user = userMapper.findbycount(usercount);
    	if(user == null) {
    		return 0; //0-无此用户
    	}
    	if(!user.getUserpassword().equals(userpassword)) {
    		return 1;//1-密码错误
    	}
    	userMapper.modifyUser(usercount,modify_userpassword);
    	return 2;
    }

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUser(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}