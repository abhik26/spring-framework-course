package com.example.dao;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public Integer saveCustomer(Customer customer);
	
	Customer getCustomer(Integer customerId);

	public void deleteCustomer(Integer customerId);
}
