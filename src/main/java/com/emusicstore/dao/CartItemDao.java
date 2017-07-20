package com.emusicstore.dao;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;

public interface CartItemDao {

	public void addCartItem(CartItem cartItem);

	public void removeCartItem(CartItem cartItem);

	public void removeAllCartItem(Cart cart);

	public CartItem getCartItemByProductId(int productId);
}
