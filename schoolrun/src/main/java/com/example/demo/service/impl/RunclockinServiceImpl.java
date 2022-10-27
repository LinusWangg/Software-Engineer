package com.example.demo.service.impl;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Runclockin;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Basetrace;
import com.example.demo.service.totalService;
import com.example.demo.service.BasetraceService;
import com.example.demo.service.RunclockinService;
//import com.example.demo.service.BasetraceService;

import com.github.pagehelper.PageHelper;

@Service("runService")
public class RunclockinServiceImpl implements RunclockinService {
	@Autowired
	private MongoTemplate mongoTemplate;
	private BasetraceService basetraceservice;
	private totalService totalService;
    // 注入mapper类
	@Override
	public Runclockin findlastsucceed(String clockin_stuid, String clockin_stuschool, short succeed) {
		Runclockin tp = new Runclockin();
		Query query = new Query(Criteria.where("clockinStuid").is(clockin_stuid).and("clockinStuschool").is(clockin_stuschool).and("clockinSucceed").is(succeed));
		Sort sort = Sort.by(Direction.DESC, "clockinTime");
		query.with(sort).limit(1);
		tp = mongoTemplate.findOne(query, Runclockin.class);
		return tp;
	}
	
	public float distance(JSONObject a,JSONObject b) {
		return Math.abs(Float.parseFloat((String) a.get("latitude")) - Float.parseFloat((String) b.get("latitude")))
				+Math.abs(Float.parseFloat((String) a.get("longitude")) - Float.parseFloat((String) b.get("longitude")));
	}
	
	public float cla_min(float a,float b,float c) {
		float minn = 100000;
		if(minn>a)
			minn=a;
		if(minn>b)
			minn=b;
		if(minn>c)
			minn=c;
		return minn;
	}
	
	public float DTW(JSONArray trace,JSONArray basetrace) {
		int t_len = trace.size();
		int b_len = basetrace.size();
		float [][]cost = new float[t_len][b_len];
		cost[0][0] = distance(trace.getJSONObject(0),basetrace.getJSONObject(0));
		for(int i=1;i<t_len;i++)
			cost[i][0] = cost[i-1][0] + distance(trace.getJSONObject(i),basetrace.getJSONObject(0));
		for(int j=1;j<b_len;j++)
			cost[0][j] = cost[0][j-1] + distance(trace.getJSONObject(0),basetrace.getJSONObject(j));
		for(int i=1;i<t_len;i++)
			for(int j=1;j<b_len;j++)
				cost[i][j] = cla_min(cost[i-1][j-1],cost[i][j-1],cost[i-1][j])+distance(trace.getJSONObject(i),basetrace.getJSONObject(j));
		return cost[t_len-1][b_len-1];
	}
    
    @Override
    public int clockin(String clockin_stuid, String clockin_stuschool, long clockin_time, JSONArray clockin_trace,
    		float run_length, int run_time, String clockin_ip,int baseid) {
    	Runclockin mci = findlastsucceed(clockin_stuid,clockin_stuschool,Short.parseShort("1"));
    	Date date = new Date(clockin_time);
		DateFormat dateformat = new SimpleDateFormat("MM-dd-HH-mm");
		String[] datestr = dateformat.format(date).toString().split("-");
		int month = Integer.parseInt(datestr[0]);
		int day = Integer.parseInt(datestr[1]);
		int hour = Integer.parseInt(datestr[2]);
		int minute = Integer.parseInt(datestr[3]);
		minute = minute/10;
    	if(mci == null) {
    		Basetrace cdm = basetraceservice.findbyid(baseid);
    		float DTW = DTW(clockin_trace,cdm.gettrace());
			if(DTW<=2.0) {
				Runclockin new_mci = new Runclockin();
				new_mci.setClockinTrace(clockin_trace);
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("1"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setRunLength(run_length);
				new_mci.setRunTime(run_time);
				new_mci.setBaseid(baseid);
				new_mci.setDtw(DTW);
				mongoTemplate.save(new_mci);
				totalService.addrun(clockin_stuid, clockin_stuschool);
				return 1;
			}
			else {
				Runclockin new_mci = new Runclockin();
				new_mci.setClockinTrace(clockin_trace);;
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("0"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setRunLength(run_length);
				new_mci.setRunTime(run_time);
				new_mci.setBaseid(baseid);
				new_mci.setDtw(DTW);
				mongoTemplate.save(new_mci);
				return 0;
			}
    	}
    	long mci_time = mci.getClockinTime();
    	Date mci_date = new Date(mci_time);
		DateFormat mci_dateformat = new SimpleDateFormat("MM-dd-HH-mm");
		String[] mci_datestr = mci_dateformat.format(mci_date).toString().split("-");
		int mci_month = Integer.parseInt(mci_datestr[0]);
		int mci_day = Integer.parseInt(mci_datestr[1]);
		if(mci_month == month && mci_day == day) {
			return 2; // 已经打过卡了
		}
		else {
			Basetrace cdm = basetraceservice.findbyid(baseid);
    		float DTW = DTW(clockin_trace,cdm.gettrace());
			if(DTW<=2.0) {
				Runclockin new_mci = new Runclockin();
				new_mci.setClockinTrace(clockin_trace);
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("1"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setRunLength(run_length);
				new_mci.setRunTime(run_time);
				new_mci.setBaseid(baseid);
				new_mci.setDtw(DTW);
				mongoTemplate.save(new_mci);
				totalService.addrun(clockin_stuid, clockin_stuschool);
				return 1;
			}
			else {
				Runclockin new_mci = new Runclockin();
				new_mci.setClockinTrace(clockin_trace);;
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("0"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setRunLength(run_length);
				new_mci.setRunTime(run_time);
				new_mci.setBaseid(baseid);
				new_mci.setDtw(DTW);
				mongoTemplate.save(new_mci);
				return 0;
			}
		}
    }
    @Override
    public List<Runclockin> getmine(String clockin_stuid, String clockin_stuschool){
    	Query query = new Query(Criteria.where("clockinStuid").is(clockin_stuid).and("clockinStuschool").is(clockin_stuschool));
    	return mongoTemplate.find(query, Runclockin.class);
    }
    @Override
    public List<Runclockin> getall(String clockin_stuschool){
    	Query query = new Query(Criteria.where("clockinStuschool").is(clockin_stuschool));
    	return mongoTemplate.find(query, Runclockin.class);
    }
}