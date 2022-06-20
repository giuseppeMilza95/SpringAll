package com.luv2code.aopdemo;


import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //  call method to find the accounts

        List<Account> theAccounts = theAccountDAO.findAccount();

        // display the accounts
        System.out.println("\n\n Program: AfterReturningDemoApp");
        System.out.println("-----------");
        System.out.println(theAccounts);
        System.out.println("\n");


        //close the context
        context.close();
    }
}
