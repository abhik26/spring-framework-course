package com.example.springmvcdemo;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(false);
		webDataBinder.registerCustomEditor(String.class, trimmer);
	}
	
	@RequestMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("countryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/process-form")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		System.out.println(student);
		
		if (bindingResult.hasErrors()) {
			return "student-form";
		} else {
			return "student-confirmation";
		}
	}
}
