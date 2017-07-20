package com.emusicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public void addCustomer(Customer customer) {

		dao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {

		return dao.getCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return dao.getAllCustomers();
	}

	@Override
	public Customer getCustomerByUserName(String userName) {

		return dao.getCustomerByUserName(userName);
	}

}
