package com.emusicstore.dao;

import com.emusicstore.model.Cart;

public interface CartDao {

	Cart create(Cart cart);

	Cart read(int id);

	void update(int id, Cart cart);

	void delete(int id);
}
