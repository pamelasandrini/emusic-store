package com.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.CartItemDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao dao;

	@Override
	public void addCartItem(CartItem cartItem) {
		dao.addCartItem(cartItem);

	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		dao.removeCartItem(cartItem);

	}

	@Override
	public void removeAllCartItem(Cart cart) {
		dao.removeAllCartItem(cart);

	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		return dao.getCartItemByProductId(productId);
	}

}
