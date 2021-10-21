package com.example.demo.service.impl;

import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;

import com.example.demo.model.Codemodel;
import com.example.demo.repository.CodemodelMapper;
import com.example.demo.service.CodemodelService;
import com.github.pagehelper.PageHelper;
import java.awt.image.BufferedImage;
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
	public List<Codemodel> getallcode(int page) {
    	int offset = 20*(page-1);
		return codemodelMapper.getallcode(offset);
	}

	public static String sendPostWithFile(String filePath) {
		DataOutputStream out = null;
		final String newLine = "\r\n";
		final String prefix = "--";
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL("https://sm.ms/api/v2/upload");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			String BOUNDARY = "-------7da2e536604c8";
			conn.setRequestMethod("POST");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestProperty("Authorization","iLVGYSLNvzn6EeoRtqCAamYS4CtGFVYO");
			out = new DataOutputStream(conn.getOutputStream());

			// 添加参数file
			File file = new File(filePath);
			StringBuilder sb1 = new StringBuilder();
			sb1.append(prefix);
			sb1.append(BOUNDARY);
			sb1.append(newLine);
			sb1.append("Content-Disposition: form-data;name=\"smfile\";filename=\"" + file.getName() + "\"" + newLine);
			sb1.append("Content-Type:application/octet-stream");
			sb1.append(newLine);
			sb1.append(newLine);
			out.write(sb1.toString().getBytes());
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			byte[] bufferOut = new byte[1024];
			int bytes = 0;
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			out.write(newLine.getBytes());
			in.close();

			byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			// 写上结尾标识
			out.write(end_data);
			out.flush();
			out.close();

			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.append(line);
				System.out.println(line);
			}
			return result.toString();
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		return result.toString();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Codemodel makecode(long born_time) {
		Codemodel same_time = new Codemodel();
		Date date = new Date(born_time);
		DateFormat dateformat = new SimpleDateFormat("MM-dd-HH-mm");
		String[] datestr = dateformat.format(date).toString().split("-");
		int month = Integer.parseInt(datestr[0]);
		int day = Integer.parseInt(datestr[1]);
		int hour = Integer.parseInt(datestr[2]);
		int minute = Integer.parseInt(datestr[3]);
		minute = minute/10;
		same_time = codemodelMapper.findbytime(month, day, hour, minute);
		if(same_time==null) {
			String born_string = getRandomString(8);
			Codemodel temp = new Codemodel();
			temp.setBornString(born_string);
			temp.setBornMonth(month);
			temp.setBornDay(day);
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
			File file=new File(System.getProperty("user.dir")+"//static//");
			if(!file.exists()){//如果文件夹不存在
				file.mkdir();//创建文件夹
			}
			File outputFile = new File(System.getProperty("user.dir")+"//static//"+datestr[0]+'-'+datestr[1]+'-'+datestr[2]+'-'+datestr[3]+".jpg");
			try {
				MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jsonObject = JSONObject.parseObject(sendPostWithFile(outputFile.toString()));
			jsonObject = JSONObject.parseObject(jsonObject.get("data").toString());
			temp.setPicAddress(jsonObject.get("url").toString());
			codemodelMapper.insertSelective(temp);
			return temp;
		}
		else {
			return same_time;
		}
	}

}