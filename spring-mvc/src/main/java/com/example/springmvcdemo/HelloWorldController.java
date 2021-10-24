package com.example.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}
	
	@RequestMapping("/processForm2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String studentName = request.getParameter("studentName");
		String message = "Yo " + studentName.toUpperCase() + "!";
		
		model.addAttribute("message", message);
		
		return "process-form";
	}
	
	@RequestMapping("/processForm3")
	public String processForm3(@RequestParam("studentName") String studentName, Model model) {
		String message = "Yo! The v3 message is for " + studentName.toUpperCase();
		
		model.addAttribute("message", message);
		
		return "process-form";
	}
}
