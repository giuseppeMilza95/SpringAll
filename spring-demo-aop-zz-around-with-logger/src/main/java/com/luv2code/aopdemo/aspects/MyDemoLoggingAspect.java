package com.luv2code.aopdemo.aspects;


import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n ==========>>> Executing @Around  on method " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method, it will handle tp target method (it will call the method getFortune)
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n========> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }





    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ==========>>> Executing @After (finally) on method " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String  method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ==========>>> Executing @AfterThrowing on method " + method);
        // log the exception
        myLogger.info("\n ==========>>> The exception is: " + theExc);

    }








    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ==========>>> Executing @AfterReturning on method " + method);

        // print out the results of the method call
        myLogger.info("\n results is: " + result);

        // let's post-process the data ... let's modify it :-)

        //Convert the account names to uppercase, we can perform also the enrichment and return the data
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n ==========>>> Executing @AfterReturning on method " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result){
            // get uppercase version of name
           String theUpperName = tempAccount.getName().toUpperCase();
            //update the name on the account
            tempAccount.setName(theUpperName);
        }



    }

    @Before("com.luv2code.aopdemo.aspects.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n=======>>>> Executing advice on addAccount()");

        // display the method signature
        MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
        // display method signature
        myLogger.info("Method: " + methodSign);

        // display method arguments

        // get arguments
        Object[] args = theJoinPoint.getArgs();


        // loop through args
        for (Object tempArgs : args){
            myLogger.info(tempArgs.toString());

            if (tempArgs instanceof Account){
                //downcast and print Account specific stuff

                Account theAccount = (Account) tempArgs;
                myLogger.info("Account name: " + theAccount.getName());
                myLogger.info("Account level: " + theAccount.getLevel());
            }
        }





    }


}
