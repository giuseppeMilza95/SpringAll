package com.luv2code.springboot.demo.mycoolapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class FunRestController {
    //Inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for "teamInfo"

    @GetMapping("teaminfo")
    public String GetTeamInfo(){
        return "Coach: " + coachName + ", Team name: " + teamName;
    }


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
