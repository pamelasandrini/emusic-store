package com.emusicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CustomerOrderDao;
import com.emusicstore.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomerOrder(CustomerOrder order) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(order);

		session.flush();

	}

}
