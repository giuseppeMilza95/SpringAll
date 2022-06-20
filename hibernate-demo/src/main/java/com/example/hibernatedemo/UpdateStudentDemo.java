package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        //set the student id. It will be used to update the database
        int studentId =1;

        try {

            // begin the transaction
            session.beginTransaction();
            // retrieve student based on the id: primary key
            Student tempStudent = session.get(Student.class, studentId);

            // set the student using the setter from the student class

            System.out.println("Updating the student...");
            tempStudent.setFirstName("Scooby");

            //commit the transaction
            session.getTransaction().commit();


            // NEW CODE

            //Get a new session
            session = factory.getCurrentSession();
            //Begin a new transaction
            session.beginTransaction();


            //Update email for all students
            System.out.println("Update email for all the students");
            session.createQuery("update Student set email='foo@gmail.com' ").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
