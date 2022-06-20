package com.luv2code.springboot.crud.demo.dao;

import com.luv2code.springboot.crud.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    //@Autowired
    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        //get the current session hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the current session hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee

        Employee employee = currentSession.get(Employee.class, id);

        //return the employee
        return employee;

    }

    @Override
    public void save(Employee employee) {
        // get the current session hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //save the employee
        currentSession.saveOrUpdate(employee);







    }

    @Override
    public void deleteById(int id) {
        // get the current session hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        // delete by primary key

        Query query = currentSession.createQuery("delete from Employee where id =:employeeId" );
        query.setParameter("employeeId", id);
        query.executeUpdate();


    }
}
