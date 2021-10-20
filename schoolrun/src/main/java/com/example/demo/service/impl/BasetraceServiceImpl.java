package com.example.demo.service.impl;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.model.Basetrace;
import com.example.demo.model.Runclockin;
import com.example.demo.service.BasetraceService;
import com.github.pagehelper.PageHelper;

@Service("basetraceService")
public class BasetraceServiceImpl implements BasetraceService {

    // 注入mapper类
	@Autowired
	private MongoTemplate mongoTemplate;
    
    @Override
    public int writein(String school, JSONArray trace) {
    	Basetrace temp = new Basetrace();
    	temp.setschool(school);
    	temp.settrace(trace);
    	Query query = new Query();
    	Sort sort = Sort.by(Direction.DESC, "basetraceid");
    	query.with(sort).limit(1);
    	Basetrace tp = mongoTemplate.findOne(query, Basetrace.class);
    	int baseid;
    	if(tp==null)
    		baseid = 1;
    	else
    		baseid = tp.getbasetraceid()+1;
    	temp.setbasetraceid(baseid);
    	mongoTemplate.save(temp);
    	return 1;
    }
    
    @Override
    public List<Basetrace> getall(String school){
    	Query query = new Query(Criteria.where("school").is(school));
    	return mongoTemplate.find(query, Basetrace.class);
    }
    
    @Override
    public List<Basetrace> get3(String school){
    	Query query = new Query(Criteria.where("school").is(school));
    	List<Basetrace> list = new ArrayList<Basetrace>();
    	list = mongoTemplate.find(query, Basetrace.class);
    	if(list.size()<=3)
    		return list;
    	else {
    		int []a = new int[]{-1,-1,-1};
    		Random random = new Random();
    		int count = 0;
    		while(count < a.length) {
    			boolean flag = true;
    			int r = random.nextInt(list.size()-1);
    			for(int i=0;i<a.length;i++) {
    				if(r==a[i]) {
    					flag=false;
    					break;
    				}
    			}
    			if(flag) {
    				a[count] = r;
    				count++;
    			}
    		}
    		List<Basetrace> list2 = new ArrayList<Basetrace>();
    		list2.add(list.get(a[0]));
    		list2.add(list.get(a[1]));
    		list2.add(list.get(a[2]));
    		return list2;
    	}
    }
    
    @Override
    public Basetrace findbyid(int id) {
    	Query query = new Query(Criteria.where("basetraceid").is(id));
    	return mongoTemplate.findOne(query, Basetrace.class);
    }

    @Override
	public Basetrace query(String school, int baseTraceId){
    	Query query = new Query((Criteria.where("basetraceid").is(baseTraceId).and("school").is(school)));
    	return mongoTemplate.findOne(query, Basetrace.class);
	}
}