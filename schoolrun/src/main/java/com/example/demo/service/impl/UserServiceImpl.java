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
    public int registUser(String usercount,String userpassword) {
    	User user = userMapper.findbycount(usercount);
    	if(user == null) {
    		User temp = new User();
    		temp.setUsercount(usercount);
    		temp.setUserpassword(userpassword);
    		userMapper.insertSelective(temp);
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
    
    @Override
    public int updateUser(String usercount,String userid,String username,String phonenum,String userschool) {
    	int flag = userMapper.updateUser(usercount,userid,username,"stu",phonenum,userschool);
    	return flag;
    }
    
    @Override
    public int loginUser(String usercount,String userpassword) {
    	User user = userMapper.findbycount(usercount);
    	if(user == null) {
    		return 0; //0-无此用户
    	}
    	if(!user.getUserpassword().equals(userpassword)) {
    		return 1;//1-密码错误
    	}
    	return 2;//2-登陆成功
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