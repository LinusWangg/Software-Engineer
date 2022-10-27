package com.example.demo.service.impl;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.total;
import com.example.demo.repository.totalMapper;
import com.example.demo.service.totalService;
import com.github.pagehelper.PageHelper;

@Service("totalService")
public class totalServiceImpl implements totalService {

    // 注入mapper类
    @Resource
    private totalMapper totalMapper;

    
    @Override
    public total getmine(String stuid, String stuschool) {
    	return totalMapper.getmine(stuid,stuschool);
    }
    @Override
    public List<total> getall(String stuschool){
    	return totalMapper.getall(stuschool);
    }
	@Override
	public int addmor(String stuid, String stuschool) {
		total mine = getmine(stuid,stuschool);
		if(mine == null) {
			total temp = new total();
			temp.setStuid(stuid);
			temp.setStuschool(stuschool);
			temp.setMorTime(1);
			temp.setRunTime(0);
			return totalMapper.insertSelective(temp);
		}
		else {
			int mor_time = mine.getMorTime()+1;
			return totalMapper.addmor(stuid, stuschool,mor_time);
		}
	}
	@Override
	public int addrun(String stuid, String stuschool) {
		total mine = getmine(stuid,stuschool);
		if(mine == null) {
			total temp = new total();
			temp.setStuid(stuid);
			temp.setStuschool(stuschool);
			temp.setMorTime(0);
			temp.setRunTime(1);
			return totalMapper.insertSelective(temp);
		}
		else {
			int run_time = mine.getRunTime()+1;
			return totalMapper.addrun(stuid, stuschool,run_time);
		}
	}
}