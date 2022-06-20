package com.luv2code.springboot.crud.demo;


import com.luv2code.springboot.crud.demo.entity.Employee;
import com.luv2code.springboot.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee =  employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + id);

        }

        return employee;
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

         Employee employee = employeeService.findById(id);
         if (employee == null){
             throw new RuntimeException("Employee id not found - " + id);


         }
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }




}
