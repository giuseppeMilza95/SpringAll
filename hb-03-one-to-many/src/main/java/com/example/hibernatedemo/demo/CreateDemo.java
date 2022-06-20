package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import com.example.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects
            // Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

            // InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 Code!!!");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();
            //save the instructor
            //Note: this will ALSO save the details object because of CascadeType.All
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
