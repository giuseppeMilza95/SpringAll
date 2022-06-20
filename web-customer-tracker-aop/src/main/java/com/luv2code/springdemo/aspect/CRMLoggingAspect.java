package com.luv2code.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.org.eclipse.jdt.internal.compiler.parser.Parser;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    public Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    //do the same for service and dao package
    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    //add @before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        //display the method that we are calling

        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=========>> in @before: calling method: " + theMethod);


        // display the arguments to the method

        //get the arguments

        Object[] arguments = joinPoint.getArgs();


        // loop through and display args
        for (Object tempArg : arguments) {
            logger.info("=========>> arguments : " + tempArg);
        }

    }


    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object theResult){

        //display method we are returning from
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=========>> in @AfterReturning: calling method: " + theMethod);

         //display data returned
        logger.info("=========>> result: " + theResult);

    }







}
