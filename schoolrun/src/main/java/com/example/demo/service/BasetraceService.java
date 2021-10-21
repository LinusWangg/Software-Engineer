package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.model.Basetrace;

import java.util.List;
import java.util.Date;

public interface BasetraceService {

	public int writein(String school, JSONArray trace);

	public List<Basetrace> getall(String school);

	public List<Basetrace> get3(String school);
	
	public Basetrace findbyid(int id);

	public Basetrace query(String school, int baseTraceId);

	public long dele(String school, int baseTraceId);
	
}