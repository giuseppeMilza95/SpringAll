package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingClass {

    //this is where we add all of our related advices for logging

    // let's start with @before advice

    //Create a pointcut to reuse multiple time
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}



    //@Before("execution(public void add*())") method start with add and with modifier public and return type void
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") account parameter and any other
    //@Before("execution(* add*(..))") any other parameter
    //@Before("execution(* add*(*))") only one parameter
    //@Before("execution(* add*())") any return types
    //@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //any return type inside  package in any class with any method and any number of parameter
    // now you can use the pointcut using the method name:
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>>> Executing advice on addAccount()");
    }

    @Before("forDaoPackage()")
    private void performeApiAnalytics(){
        System.out.println("\n==========>>>> performing APi analytics");
    }

}
