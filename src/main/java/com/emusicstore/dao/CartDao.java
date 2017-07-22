package com.emusicstore.dao;

import java.io.IOException;

import com.emusicstore.model.Cart;

public interface CartDao {

	Cart getCartById(int cartId);

	void update(Cart cart);

	Cart validate(int cartId) throws IOException;

}
