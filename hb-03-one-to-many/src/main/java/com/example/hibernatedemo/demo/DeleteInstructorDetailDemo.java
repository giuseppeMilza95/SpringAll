package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Instructor;
import com.example.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction, it similar begin and commit transaction in sql
            session.beginTransaction();
            int theId = 3;

            //get the instructor detail
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            //print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            //print rhe associated instructor
            System.out.println("The associated instructor" + tempInstructorDetail.getInstructor());



            //Remove the associated object reference
            // break bi-directional link

            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            
            // now let's delete the instructor detail
            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);


            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } catch (Exception exc){
            exc.printStackTrace();
        }

        finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
