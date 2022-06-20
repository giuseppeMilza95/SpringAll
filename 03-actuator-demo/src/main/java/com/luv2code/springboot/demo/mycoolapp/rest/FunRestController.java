package com.luv2code.springboot.demo.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class FunRestController {


    @GetMapping("/")
    public String hello(){
        return "Hello World Time on server is " + LocalDateTime.now();
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 4k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

}
