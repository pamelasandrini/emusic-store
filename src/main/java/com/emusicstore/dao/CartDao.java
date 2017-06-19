package com.emusicstore.dao;

import com.emusicstore.model.Cart;

public interface CartDao {

	Cart create(Cart cart);

	Cart read(String id);

	void update(String id, Cart cart);

	void delete(String id);
}
