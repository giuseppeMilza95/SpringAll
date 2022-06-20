package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();

            // get the pacman course from db
             int courseId = 10;

             Course tempCourse = session.get(Course.class, courseId);
            // delete the course
            System.out.println("Deleting course: "  + tempCourse);

            session.delete(tempCourse);


            session.getTransaction().commit();
            System.out.println("Done!");



        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
