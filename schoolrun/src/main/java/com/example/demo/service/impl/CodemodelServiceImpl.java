package com.example.demo.service.impl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.example.demo.model.Codemodel;
import com.example.demo.repository.CodemodelMapper;
import com.example.demo.service.CodemodelService;
import com.github.pagehelper.PageHelper;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import java.util.Hashtable;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;

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
	
	@SuppressWarnings("deprecation")
	@Override
	public void makecode(int born_time) {
		Codemodel same_time = new Codemodel();
		Date date = new Date(born_time);
		DateFormat dateformat = new SimpleDateFormat("MM-dd-hh-mm");
		String[] datestr = dateformat.format(date).toString().split("-");
		int month = Integer.parseInt(datestr[0]);
		int day = Integer.parseInt(datestr[1]);
		int hour = Integer.parseInt(datestr[2]);
		int minute = Integer.parseInt(datestr[3]);
		System.out.println(minute);
		minute = minute/10;
		System.out.println(minute);
		same_time = codemodelMapper.findbytime(month, day, hour, minute);
		if(same_time==null) {
			String born_string = getRandomString(8);
			Codemodel temp = new Codemodel();
			temp.setBornString(born_string);
			temp.setBornMonth(month);
			temp.setBronDay(day);
			temp.setBornHour(hour);
			temp.setBornMinute(minute);
			int width = 300; // 二维码图片宽度
			int height = 300; // 二维码图片高度
			String format = "jpg";// 二维码的图片格式
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
			BitMatrix bitMatrix = new BitMatrix(height);
			try {
				bitMatrix = new MultiFormatWriter().encode(born_string,BarcodeFormat.QR_CODE, width, height, hints);
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File outputFile = new File("./src/main/resources/static/"+datestr[0]+'-'+datestr[1]+'-'+datestr[2]+'-'+datestr[3]+".jpg");
			try {
				MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp.setPicAddress(outputFile.toString());
			codemodelMapper.insertSelective(temp);
		}
	}

}