package com.example.demo.service;

import com.example.demo.model.Codemodel;

import java.util.List;
import java.util.Date;

public interface CodemodelService {

	public List<Codemodel> getallcode();
	
	public void makecode(int born_time);
	
}