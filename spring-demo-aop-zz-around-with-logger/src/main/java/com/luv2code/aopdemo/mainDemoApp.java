package com.luv2code.aopdemo;


import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class mainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        // get the bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        // call the business method
        Account myAccount  = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // get the accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setName("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // call the business method

        theAccountDAO.doWork();
        //close the context
        context.close();
    }

    public static class AfterThrowingDemoApp {
        public static void main(String[] args) {
            // read spring config java class
            AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(DemoConfig.class);

            // get the bean from spring container
            AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

            //  call method to find the accounts
            List<Account> theAccounts = null;
            try {
                boolean tripWire = true;
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
}
