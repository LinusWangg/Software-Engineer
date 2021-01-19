package com.example.demo.service.impl;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Appeal;
import com.example.demo.repository.AppealMapper;
import com.example.demo.service.AppealService;
import com.github.pagehelper.PageHelper;

@Service("appealService")
public class AppealServiceImpl implements AppealService {

    // 注入mapper类
    @Resource
    private AppealMapper appealMapper;
    
    @Override
    public int submit(String appeal_stuid, String appeal_school, long appeal_time, String appeal_content,
			int appeal_condition) {
    	Appeal temp = new Appeal();
    	temp.setAppealStuid(appeal_stuid);
    	temp.setAppealSchool(appeal_school);
    	temp.setAppealTime(appeal_time);
    	temp.setAppealContent(appeal_content);
    	temp.setAppealCondition(appeal_condition);
    	appealMapper.insertSelective(temp);
    	return 1;
    }
    
    public int finish(String appeal_stuid, String appeal_school, long appeal_time, String appeal_adminid, int appeal_condition) {
    	return appealMapper.finish(appeal_stuid,appeal_school,appeal_time,appeal_adminid,appeal_condition);
    }
    
}