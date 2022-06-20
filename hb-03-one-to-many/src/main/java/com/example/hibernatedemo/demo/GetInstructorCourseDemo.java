package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Course;
import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {
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
            System.out.println("Instructor: " + tempInstructor);
            //get coursed for the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
