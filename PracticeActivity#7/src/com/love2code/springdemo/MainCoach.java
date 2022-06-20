package com.love2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCoach {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        BoxCoach boxCoach = context.getBean("boxCoach",BoxCoach.class);

        System.out.println(boxCoach.getDailyFortune());
        System.out.println(boxCoach.getDailyWorkOut());

        context.close();
    }
}
