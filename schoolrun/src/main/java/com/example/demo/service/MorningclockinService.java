package com.example.demo.service;

import com.example.demo.model.Morningclockin;
import java.util.List;

public interface MorningclockinService {

	public int clockin(String clockin_stuid, String clockin_stuschool, long clockin_time, String clockin_code,
			String clockin_ip, float longitude, float latitude);
	
	public List<Morningclockin> getmine(String clockin_stuid, String clockin_stuschool);
    
	public List<Morningclockin> getall(String clockin_stuschool, int page);
}