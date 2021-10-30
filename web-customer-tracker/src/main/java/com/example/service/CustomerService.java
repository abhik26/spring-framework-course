package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	Integer saveCustomer(Customer customer);
	
	Customer getCustomer(Integer customerId);

	void deleteCustomer(Integer customerId);
}
