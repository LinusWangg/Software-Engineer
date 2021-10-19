package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Appeal;

public interface AppealMapper {
    int insert(Appeal record);

    int insertSelective(Appeal record);

	int finish(String appeal_stuid, String appeal_school, long appeal_time, String appeal_adminid, int appeal_condition);
	
	List<Appeal> getall(String appeal_school, int offset);

	List<Appeal> getmine(String appeal_stuid, String appeal_school);
}