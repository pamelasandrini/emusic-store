package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);

		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());

		// create a new user for login
		Users newUser = new Users();
		newUser.setCustomerId(customer.getCustomerId());
		newUser.setEnabled(true);
		newUser.setPassword(customer.getPassword());
		newUser.setUserName(customer.getUsername());

		// create new authority
		Authorities newAuthority = new Authorities();
		newAuthority.setAuthority("ROLE_USER");
		newAuthority.setUserName(customer.getUsername());

		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);

		// create a cart, only one cart for user
		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);

		session.saveOrUpdate(cart);
		session.saveOrUpdate(customer);

		session.flush();
	}

	@Override
	public Customer getCustomerById(int id) {

		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomers() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();

		return list;
	}

	@Override
	public Customer getCustomerByUserName(String userName) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0, userName);

		session.flush();

		return (Customer) query.uniqueResult();
	}

}
