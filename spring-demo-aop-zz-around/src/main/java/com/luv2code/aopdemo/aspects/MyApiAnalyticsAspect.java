package com.luv2code.aopdemo.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    //You must specify the path for the class, in our case we have to use Luv.AopExpressions
    @Before("com.luv2code.aopdemo.aspects.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    private void performApiAnalytics(){
        System.out.println("\n==========>>>> performing APi analytics");
    }

}
