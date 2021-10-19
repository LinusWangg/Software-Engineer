package com.example.demo.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HTMLControl {
    @RequestMapping("/qrcode")
    public String index(){
        return "QRCode";
    }
    
    @RequestMapping("/login")
    public String index2(){
        return "login";
    }

    @RequestMapping("/morning")
    public String index3(){
        return "morning";
    }

    @RequestMapping("/run")
    public String index4(){
        return "run";
    }

    @RequestMapping("/appeals")
    public String index5(){
        return "appeal";
    }

    @RequestMapping("/basetraces")
    public String index6(){
        return "basetrace";
    }
}