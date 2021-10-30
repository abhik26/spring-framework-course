package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CustomerDao;
import com.example.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public Integer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
