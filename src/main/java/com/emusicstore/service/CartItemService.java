package com.emusicstore.service;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;

public interface CartItemService {

	public void addCartItem(CartItem cartItem);

	public void removeCartItem(CartItem cartItem);

	public void removeAllCartItem(Cart cart);

	public CartItem getCartItemByProductId(int productId);
}
