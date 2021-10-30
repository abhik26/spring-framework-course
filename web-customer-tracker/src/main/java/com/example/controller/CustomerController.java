package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/list")
	public String getCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "customer-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer) {
		
		System.out.println("Saved customer id: " + customerService.saveCustomer(customer));
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, 
			@RequestParam("customerId") Integer customerId) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
