package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.fastjson.JSONArray;

@SpringBootApplication
//指定要扫描的mybatis映射类的路径
@MapperScan("com.example.demo.repository")
public class SchoolrunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolrunApplication.class, args);
	}

}
