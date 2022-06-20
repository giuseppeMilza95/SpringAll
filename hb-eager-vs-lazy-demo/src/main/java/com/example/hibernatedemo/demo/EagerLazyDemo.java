package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Course;
import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();

            // get the instructor from db

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("luv2code: Instructor: " + tempInstructor);

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            //close the session
            session.close();

            System.out.println("luv2code: The session is now closed!\n");

            //Option 1: call getter method while session is open

            //get coursed for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
            System.out.println("luv2code: Done!");


        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
