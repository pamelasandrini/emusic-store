package com.emusicstore.service;

import com.emusicstore.model.Cart;

public interface CartService {

	public Cart getCartById(int cartId);
	
	public void update(Cart cart);
}
