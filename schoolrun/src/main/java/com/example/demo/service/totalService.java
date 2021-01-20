package com.example.demo.service;

import com.example.demo.model.total;
import java.util.List;

public interface totalService {
	
	public total getmine(String stuid, String stuschool);
    
	public List<total> getall(String stuschool);
	
	public int addmor(String stuid, String stuschool);
	
	public int addrun(String stuid, String stuschool);
}