package com.luv2code.springdemo.rest;


import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // Define the @PostConstruct to load the student data ... olnly once

    @PostConstruct
    public void loadData(){
        theStudents = List.of(
                new Student("Giuseppe", "Tumminello"),
                new Student("Giovanni", "Tumminello"),
                new Student("Agata", "Miedzinska"));

    }


    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if (studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFound("Student not found with id - " + studentId);
        }
        return theStudents.get(studentId);

    }




    // add new exception handler to catch all the exception
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> allExceptionHandler(Exception exc){
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }


}
