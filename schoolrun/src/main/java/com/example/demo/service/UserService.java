package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    public User getUserById(int userId);
    
    public List<User> listUser(int page, int pageSize);
    
    public int registUser(String usercount,String userpassword);
    
    public int updateUser(String usercount,String userid,String username,String phonenum,String userschool);
    
    public int loginUser(String usercount,String userpassword);
    
    public int modifyUser(String usercount,String userpassword,String modify_userpassword);
}