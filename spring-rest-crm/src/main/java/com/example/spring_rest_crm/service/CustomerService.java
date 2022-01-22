package com.example.spring_rest_crm.service;

import java.util.List;

import com.example.spring_rest_crm.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveOrUpdateCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
