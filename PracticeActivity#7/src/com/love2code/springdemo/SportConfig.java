package com.love2code.springdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class SportConfig {

    @Bean
    public GoodFortuneService goodFortuneService(){
        return new GoodFortuneService();
    }

    @Bean
    public Coach boxCoach(){
        return new BoxCoach(goodFortuneService());
    }
}
