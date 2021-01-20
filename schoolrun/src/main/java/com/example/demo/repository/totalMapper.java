package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.total;

public interface totalMapper {
    int insert(total record);

    int insertSelective(total record);

	total getmine(String stuid, String stuschool);

	List<total> getall(String stuschool);

	int addmor(String stuid, String stuschool, int mor_time);

	int addrun(String stuid, String stuschool, int run_time);
}