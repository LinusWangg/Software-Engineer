package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Codemodel;
import com.example.demo.service.CodemodelService;
import java.util.List;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@RequestMapping("/codemodel")
public class CodemodelController {

    // 注入mapper类
    @Resource
    private CodemodelService codemodelService;

    @RequestMapping(path="showallcode",method=RequestMethod.GET,produces="application/json")
    public List<Codemodel> getallcode(){
    	return codemodelService.getallcode();
    }
    
    @RequestMapping(path="makecode",method=RequestMethod.POST,produces="application/json")
    public void makecode(
    		@RequestParam("born_time") int born_time) {
    	codemodelService.makecode(born_time);
    }
}