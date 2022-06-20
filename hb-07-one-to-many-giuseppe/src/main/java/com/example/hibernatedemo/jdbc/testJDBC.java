package com.example.hibernatedemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {






    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-07-one-to-many-giuseppe?useSSL=false&serverTimezone=UTC";
        String user ="hbstudent";
        String pass ="hbstudent";



        try{
            System.out.println("Connecting to database" + jdbcURL);
            Connection myConn = DriverManager.getConnection(jdbcURL,user, pass);
            System.out.println("Connection successfull");





        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
