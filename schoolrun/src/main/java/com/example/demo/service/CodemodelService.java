package com.example.demo.service;

import com.example.demo.model.Codemodel;

import java.util.List;
import java.util.Date;

public interface CodemodelService {

	public List<Codemodel> getallcode(int page);
	
	public Codemodel makecode(long born_time);

	public Codemodel query(int month, int day, int hour, int minute);
}