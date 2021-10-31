package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    User findbycount(String usercount);

	int updateUser(String usercount, String userid, String username);
	
	void modifyUser(String usercount,String modify_userpassword);

	List<User> getall(String school, int offset);
}