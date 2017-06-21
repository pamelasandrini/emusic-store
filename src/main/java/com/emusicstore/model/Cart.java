package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<Integer, CartItem> cartItems;
	private double grandTotal;

	public Cart() {
		cartItems = new HashMap<>();
		grandTotal = 0;
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {

		int productId = item.getProduct().getId();

		if (cartItems.containsKey(productId)) {
			// get the existing item
			CartItem existingItem = cartItems.get(productId);
			// update the quantity
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
			existingItem.setTotalPrice(existingItem.getTotalPrice() + item.getTotalPrice());

			// update the item
			cartItems.put(productId, existingItem);
		} else {

			cartItems.put(productId, item);
		}

		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {

		int productId = item.getProduct().getId();
		cartItems.remove(productId);

		updateGrandTotal();
	}

	private void updateGrandTotal() {

		grandTotal = 0;
		cartItems.values().stream().forEach(i -> grandTotal = grandTotal + i.getTotalPrice());
	}
}
			