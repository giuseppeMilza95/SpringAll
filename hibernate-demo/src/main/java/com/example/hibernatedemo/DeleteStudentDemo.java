package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();


        //set the student id. It will be used to update the database


        try {
            int studentId = 1;
            //now get a new session
            session = factory.getCurrentSession();

            // begin the transaction
            session.beginTransaction();


            // retrieve student based on the id: primary key
            Student tempStudent = session.get(Student.class, studentId);

            // delete the student
            // System.out.println("Deleting student: " + tempStudent);
            // session.delete(tempStudent);

            System.out.println("Deleting Student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();


            // delete student id=2


            //commit the transaction
            session.getTransaction().commit();


            // NEW CODE

            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
