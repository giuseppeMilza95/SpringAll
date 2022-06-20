package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();

        try {

            //create a student object
            System.out.println("creating a new student object ...");
            Student tempStudent = new Student("Giuseppe", "Tumminello", "love2@code.com");

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();


            //save the student object,
            System.out.println("Saving the student");
            session.save(tempStudent);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
