package com.example.demo.repository;

import com.example.demo.model.Appeal;

public interface AppealMapper {
    int insert(Appeal record);

    int insertSelective(Appeal record);

	int finish(String appeal_stuid, String appeal_school, long appeal_time, String appeal_adminid, int appeal_condition);
}