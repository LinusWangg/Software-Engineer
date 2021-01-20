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
import com.example.demo.model.Codemodel;
import com.example.demo.service.RunclockinService;
//import com.example.demo.service.BasetraceService;

import com.github.pagehelper.PageHelper;

@Service("runService")
public class RunclockinServiceImpl implements RunclockinService {
	@Autowired
	private MongoTemplate mongoTemplate;
	//private BasetraceService basetraceservice;
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
    		//Basetrace cdm = basetraceservice.findbyid(baseid);
			/*if(cdm.getBornString().equals(clockin_code)) {
				Morningclockin new_mci = new Morningclockin();
				new_mci.setClockinCode(clockin_code);
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("1"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setLatitude(latitude);
				new_mci.setLongitude(longitude);
				morningclockinMapper.insert(new_mci);
				return 1;
			}
			else {*/
				Runclockin new_mci = new Runclockin();
				new_mci.setClockinTrace(clockin_trace);;
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("1"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setRunLength(run_length);
				new_mci.setRunTime(run_time);
				mongoTemplate.save(new_mci);
				return 1;
			//}
    	}
    	long mci_time = mci.getClockinTime();
    	Date mci_date = new Date(mci_time);
		DateFormat mci_dateformat = new SimpleDateFormat("MM-dd-HH-mm");
		String[] mci_datestr = mci_dateformat.format(mci_date).toString().split("-");
		int mci_month = Integer.parseInt(mci_datestr[0]);
		int mci_day = Integer.parseInt(mci_datestr[1]);
		/*System.out.println(month);
		System.out.println(mci_month);
		System.out.println(day);
		System.out.println(mci_day);*/
		if(mci_month == month && mci_day == day) {
			return 2; // 已经打过卡了
		}
		/*else {
			Codemodel cdm = codemodelMapper.findbytime(month,day,hour,minute);
			if(cdm.getBornString().equals(clockin_code)) {
				Morningclockin new_mci = new Morningclockin();
				new_mci.setClockinCode(clockin_code);
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("1"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setLatitude(latitude);
				new_mci.setLongitude(longitude);
				morningclockinMapper.insert(new_mci);
				System.out.println(3);
				return 1;
			}
			else {
				Morningclockin new_mci = new Morningclockin();
				new_mci.setClockinCode(clockin_code);
				new_mci.setClockinIp(clockin_ip);
				new_mci.setClockinStuid(clockin_stuid);
				new_mci.setClockinStuschool(clockin_stuschool);
				new_mci.setClockinSucceed(Short.parseShort("0"));
				new_mci.setClockinTime(clockin_time);
				new_mci.setLatitude(latitude);
				new_mci.setLongitude(longitude);
				morningclockinMapper.insert(new_mci);
				System.out.println(4);
				return 0;
			}
		}*/
		return 3;
    }
}