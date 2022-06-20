package com.example;
import org.springframework.beans.factory.annotation.Configurable;



import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/form")
    public String showForm(){
        return "form";
    }
}
