package com.emusicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, cartId);

		session.flush();

		return cart;
	}

	@Override
	public void update(Cart cart) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);

		session.flush();

	}

}
