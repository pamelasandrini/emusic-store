package com.emusicstore.service;

import java.util.List;

import com.emusicstore.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public List<Customer> getAllCustomers();
}
