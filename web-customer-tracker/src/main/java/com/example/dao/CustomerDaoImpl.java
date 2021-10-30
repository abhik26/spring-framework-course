package com.example.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public CustomerDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		// get current session
		Session session = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		
		// execute query
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public Integer saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		return customer.getId();
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.find(Customer.class, customerId);
		session.delete(customer);
	}

}
