package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Course;
import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;

public class FetchJoinDemo {
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

            int theId = 1;
            //Option 2: Hibernate query with HQL
            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);


            //set parameter on query

            query.setParameter("theInstructorId", theId);

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();


            // get the instructor from db


            System.out.println("luv2code: Instructor: " + tempInstructor);


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
