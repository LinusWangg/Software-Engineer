package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.example.demo.outDTO.morningClockinDTO;
import com.example.demo.utils.Assembles;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Morningclockin;
import com.example.demo.service.MorningclockinService;
import com.example.demo.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/morningclockin")
public class MorningclockinController {

    // 注入mapper类
    @Resource
    private MorningclockinService morningclockinService;

    /*@RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }*/
    
    @RequestMapping(path="clockin",method=RequestMethod.POST)
    public int clockin(
    		@RequestParam HashMap<String, String> map) {
    	String clockin_stuid = map.get("clockin_stuid");
    	String clockin_stuschool = map.get("clockin_stuschool");
    	long clockin_time = Long.parseLong(map.get("clockin_time"));
    	String clockin_code = map.get("clockin_code");
    	String clockin_ip = map.get("clockin_ip");
    	float longitude = Float.parseFloat(map.get("longitude"));
    	float latitude = Float.parseFloat(map.get("latitude"));
    	int flag = morningclockinService.clockin(clockin_stuid,clockin_stuschool,clockin_time,clockin_code,clockin_ip,longitude,latitude);
    	return flag;
    }
    
    @RequestMapping(path="getmine",method=RequestMethod.POST)
    public List<Morningclockin> getmine(
    		@RequestParam HashMap<String, String> map) {
    	String clockin_stuid = map.get("clockin_stuid");
    	String clockin_stuschool = map.get("clockin_stuschool");
    	return morningclockinService.getmine(clockin_stuid,clockin_stuschool);
    }
    
    @RequestMapping(path="getall",method=RequestMethod.POST,produces="application/json")
    public List<morningClockinDTO> getall(
    		@RequestBody HashMap<String, String> map) {
    	String clockin_stuschool = map.get("clockin_stuschool");
    	int page = Integer.parseInt(map.get("page"));
    	List<Morningclockin> morningclockinList = morningclockinService.getall(clockin_stuschool, page);
    	List<morningClockinDTO> respDTO = new ArrayList<morningClockinDTO>();
		for(Morningclockin clockin : morningclockinList){
			respDTO.add(Assembles.assemble(clockin));
		}
		return respDTO;
    }
}