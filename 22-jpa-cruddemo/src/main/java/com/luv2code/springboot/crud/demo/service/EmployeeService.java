package com.luv2code.springboot.crud.demo.service;

import com.luv2code.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
