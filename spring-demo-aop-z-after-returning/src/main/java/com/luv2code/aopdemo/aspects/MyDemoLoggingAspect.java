package com.luv2code.aopdemo.aspects;


import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ==========>>> Executing @AfterReturning on method " + method);

        // print out the results of the method call
        System.out.println("\n results is: " + result);

        // let's post-process the data ... let's modify it :-)

        //Convert the account names to uppercase, we can perform also the enrichment and return the data
        convertAccountNamesToUpperCase(result);

        System.out.println("\n ==========>>> Executing @AfterReturning on method " + result);
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
