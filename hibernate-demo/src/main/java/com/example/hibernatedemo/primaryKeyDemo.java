package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class primaryKeyDemo {


    public static void main(String[] args) {

        //Create Factory and link that hibernate xml file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            //create 3 students object
            System.out.println("creating a new student object ...");
            Student tempStudent1 = new Student("Mary", "Public", "mary@code.com");
            Student tempStudent2 = new Student("John", "Doe", "john@code.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@code.com");

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();


            //save the student object,
            System.out.println("Saving the student.......");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
