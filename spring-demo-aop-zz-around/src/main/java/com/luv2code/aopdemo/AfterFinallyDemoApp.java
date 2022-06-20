package com.luv2code.aopdemo;


import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //  call method to find the accounts
        List<Account> theAccounts = null;
        try {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccount(tripWire);
        }catch (Exception exc){
            System.out.println("\n\nMain ... program caught exception: " + exc);
        }

        // display the accounts
        System.out.println("\n\n Program: AfterThrowingDemoApp");
        System.out.println("-----------");
        System.out.println(theAccounts);
        System.out.println("\n");


        //close the context
        context.close();
    }
}
