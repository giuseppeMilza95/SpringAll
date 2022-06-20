package com.luv2code.springboot.crud.demo.dao;

import com.luv2code.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);
    void deleteById(int id);
}
