package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Course;
import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import com.example.hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesAndReviewsDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();


            // get the course
            int theId = 13;

            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse);



            // print the course

            System.out.println(tempCourse);

            //print the corse review

            System.out.println(tempCourse.getReviews());

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
