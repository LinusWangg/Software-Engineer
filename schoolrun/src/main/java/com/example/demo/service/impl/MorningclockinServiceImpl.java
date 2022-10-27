package com.example.demo.service.impl;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Morningclockin;
import com.example.demo.model.Codemodel;
import com.example.demo.repository.MorningclockinMapper;
import com.example.demo.repository.CodemodelMapper;
import com.example.demo.service.MorningclockinService;
import com.example.demo.service.totalService;
import com.github.pagehelper.PageHelper;

@Service("morningService")
public class MorningclockinServiceImpl implements MorningclockinService {

    // 注入mapper类
    @Resource
    private MorningclockinMapper morningclockinMapper;
    @Resource
    private CodemodelMapper codemodelMapper;
    @Autowired
    private totalService totalService;
    
    @Override
    public int clockin(String clockin_stuid, String clockin_stuschool, long clockin_time, String clockin_code,
			String clockin_ip, float longitude, float latitude) {
    	Morningclockin mci = morningclockinMapper.findlastsucceed(clockin_stuid,clockin_stuschool,Short.parseShort("1"));
    	Date date = new Date(clockin_time);
		DateFormat dateformat = new SimpleDateFormat("MM-dd-HH-mm");
		String[] datestr = dateformat.format(date).toString().split("-");
		int month = Integer.parseInt(datestr[0]);
		int day = Integer.parseInt(datestr[1]);
		int hour = Integer.parseInt(datestr[2]);
		int minute = Integer.parseInt(datestr[3]);
		minute = minute/10;
    	if(mci == null) {
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
				totalService.addmor(clockin_stuid, clockin_stuschool);
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
				totalService.addmor(clockin_stuid, clockin_stuschool);
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
				return 0;
			}
		}
    }
    @Override
    public List<Morningclockin> getmine(String clockin_stuid, String clockin_stuschool){
		return morningclockinMapper.getmine(clockin_stuid, clockin_stuschool);
    }
    @Override
    public List<Morningclockin> getall(String clockin_stuschool){
    	return morningclockinMapper.getall(clockin_stuschool);
    }
}