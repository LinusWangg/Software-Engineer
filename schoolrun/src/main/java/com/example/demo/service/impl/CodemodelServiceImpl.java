package com.example.demo.service.impl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.model.Codemodel;
import com.example.demo.repository.CodemodelMapper;
import com.example.demo.service.CodemodelService;
import com.github.pagehelper.PageHelper;

@Service("codemodelService")
public class CodemodelServiceImpl implements CodemodelService {

	// 注入mapper类
    @Resource
    private CodemodelMapper codemodelMapper;
    

    public static String getRandomString(int length) {
    	String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    	Random random = new Random();
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < length; i++) {
    		int number = random.nextInt(str.length());
    		sb.append(str.charAt(number));
    	}
    	return sb.toString();
    }
    
	@Override
	public List<Codemodel> getallcode() {
		return codemodelMapper.getallcode();
	}
	
	@Override
	public void makecode(int born_time) {
		String born_string = getRandomString(8);
		Codemodel temp = new Codemodel();
		temp.setBornTime(born_time);
		temp.setBornString(born_string);
		codemodelMapper.insertSelective(temp);
	}

}