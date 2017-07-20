package com.emusicstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 5412546021670798883L;

	@Id
	@GeneratedValue
	private int cartId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;

	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;

	private double grandTotal;

	public Cart() {
		cartItems = new ArrayList<>();
	}

	public Cart(int id) {
		this.cartId = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}

	public void removeCartItem(CartItem cartItem) {
		cartItems.remove(cartItem);
	}
	
	public boolean productExists(Product product)
	{
		return cartItems.stream().anyMatch(i -> i.getProduct().getId() == product.getId());
	}
	
	public CartItem getCartItemByProduct(Product product)
	{
		
		for (CartItem item : cartItems) {
			
			if(item.getProduct().getId() == product.getId())
			{
				return item;
			}
		}
		
		return null;
	}
}
