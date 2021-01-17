package com.example.demo.repository;

import com.example.demo.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
    User findbycount(String usercount);

	int updateUser(String usercount, String userid, String username, String usertype, String phonenum, String userschool);
	
	void modifyUser(String usercount,String modify_userpassword);
}