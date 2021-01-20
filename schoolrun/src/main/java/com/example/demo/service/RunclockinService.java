package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Morningclockin;
import com.example.demo.model.Runclockin;
import java.util.List;

public interface RunclockinService {
	
	public Runclockin findlastsucceed(String clockin_stuid, String clockin_stuschool,short succeed);

	public int clockin(String clockin_stuid, String clockin_stuschool, long clockin_time, JSONArray clockin_trace,
			float run_length, int run_time, String clockin_ip,int baseid);

	public List<Runclockin> getmine(String clockin_stuid, String clockin_stuschool);

	public List<Runclockin> getall(String clockin_stuschool);
	
}