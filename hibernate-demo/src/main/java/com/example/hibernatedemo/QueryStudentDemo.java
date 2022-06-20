package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory, session factory is need to configure hirbernate, place the file hibernate.cfg.xml under resources file
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session

        Session session = factory.getCurrentSession();

        try {
            //begin transaction
            session.beginTransaction();

            //query student

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the students

            displayStudent(theStudents);

            //query student: lastName = Doe

            theStudents = session.createQuery("from Student where lastName = 'Doe'").getResultList();
          


            //display the students
            System.out.println("Students who have last name of Doe");
            displayStudent(theStudents);
            //query students: lastName = 'Doe' OR firstName= 'Daffy'
            theStudents = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            System.out.println("Students who have last name of Doe and firstName = Daffy");
            displayStudent(theStudents);


            //query students where email LIKE %luv2code.com
            theStudents = session.createQuery("from Student s where s.email LIKE '%code.com'").getResultList();

            System.out.println("\n\nStudents who email ends with luv2code.com");
            displayStudent(theStudents);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }

    private static void displayStudent(List<Student> theStudents) {
        for (Student student : theStudents) {
            System.out.println(student);
        }
    }
}
