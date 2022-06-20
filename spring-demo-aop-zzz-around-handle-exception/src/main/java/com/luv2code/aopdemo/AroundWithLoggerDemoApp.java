package com.luv2code.aopdemo;


import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = theFortuneService.getFortune();
        myLogger.info("\nMain program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        myLogger.info("\nMy Fortune is: " + data);
        myLogger.info("Finished");

        //close the context
        context.close();
    }
}
