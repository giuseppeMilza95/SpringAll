package com.example.hibernatedemo.demo;

import com.example.hibernatedemo.entity.Employee;
import com.example.hibernatedemo.entity.Task;
import com.zaxxer.hikari.util.ClockSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.context.annotation.Configurations;

public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Task.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            Employee agata = new Employee("Agata", "Miedzinska", "Accountant");
            Task sap = new Task("SAP", 45);
            Task meeting = new Task("meeting", 60);

           agata.addTask(sap);
           agata.addTask(meeting);
           session.save(agata);







            session.getTransaction().commit();














    }catch (Exception e){e.printStackTrace();}




    }
}
