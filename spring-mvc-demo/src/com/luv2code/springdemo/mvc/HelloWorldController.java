package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need controller method proccess the html form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}
	
	//new a controller method to read form data and add data to a model
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from  html form
		String theName = request.getParameter("studentName");
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! " + theName;
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
}
	@RequestMapping("/processFormThree")
	public String processFormVersionthree(@RequestParam("studentName") String theName, Model model) {
		// read the request parameter from  html form
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hey my friend from v3! " + theName;
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
}	

}
