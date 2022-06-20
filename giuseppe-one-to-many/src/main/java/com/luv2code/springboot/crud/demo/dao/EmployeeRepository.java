package com.luv2code.springboot.crud.demo.dao;

import com.luv2code.springboot.crud.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
