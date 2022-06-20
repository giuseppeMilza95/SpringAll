package com.luv2code.aopdemo;


import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = theFortuneService.getFortune();
        System.out.println("\nMain program: AroundDemoApp");
        System.out.println("Calling getFortune");
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");

        //close the context
        context.close();
    }
}
