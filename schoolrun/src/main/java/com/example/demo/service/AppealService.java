package com.example.demo.service;

import com.example.demo.model.Appeal;
import java.util.List;

public interface AppealService {

	public int submit(String appeal_stuid, String appeal_school, long appeal_time, String appeal_content,
			int appeal_condition);

	public int finish(String appeal_stuid, String appeal_school, long appeal_time, String appeal_adminid, int appeal_condition);

	public List<Appeal> getall(String appeal_school);

	public List<Appeal> getmine(String appeal_stuid, String appeal_school);

}