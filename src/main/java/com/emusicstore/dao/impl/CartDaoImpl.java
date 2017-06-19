package com.emusicstore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private Map<String, Cart> listOfCarts;

	public CartDaoImpl() {

		listOfCarts = new HashMap<>();
	}

	@Override
	public Cart create(Cart cart) {

		if (listOfCarts.keySet().contains(cart.getCartId())) {
			// throw an error
			throw new IllegalArgumentException(
					"Can not create a cart. A cart with the given id already existis: " + cart.getCartId());
		}

		listOfCarts.put(cart.getCartId(), cart);

		return cart;
	}

	@Override
	public Cart read(String id) {
		return listOfCarts.get(id);
	}

	@Override
	public void update(String id, Cart cart) {

		if (listOfCarts.keySet().contains(cart.getCartId())) {
			// throw an error
			throw new IllegalArgumentException(
					"Can not update the cart. A cart with the given id doesn't existis: " + cart.getCartId());
		}

		listOfCarts.put(cart.getCartId(), cart);

	}

	@Override
	public void delete(String id) {
		if (listOfCarts.keySet().contains(id)) {
			// throw an error
			throw new IllegalArgumentException(
					"Can not delete the cart. A cart with the given id doesn't existis: " + id);
		}

		listOfCarts.remove(id);
	}

}
