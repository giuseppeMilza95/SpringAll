package com.luv2code.aopdemo.aspects;


import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingClass {

    @Before("com.luv2code.aopdemo.aspects.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=======>>>> Executing advice on addAccount()");

        // display the method signature
        MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
        // display method signature
        System.out.println("Method: " + methodSign);

        // display method arguments

        // get arguments
        Object[] args = theJoinPoint.getArgs();


        // loop through args
        for (Object tempArgs : args){
            System.out.println(tempArgs);

            if (tempArgs instanceof Account){
                //downcast and print Account specific stuff

                Account theAccount = (Account) tempArgs;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }





    }


}
