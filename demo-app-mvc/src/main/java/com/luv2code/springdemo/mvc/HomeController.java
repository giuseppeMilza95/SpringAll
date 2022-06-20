package com.luv2code.springdemo.mvc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    String appName;
    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }



}
