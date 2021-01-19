package com.example.demo.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HTMLControl {
    @RequestMapping("/qrcode")
    public String index(){
        return "QRCode";
    }
}