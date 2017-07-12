package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.model.Product;

public interface ProductDao {

	void addProduct(Product product);
	
	void updateProduct(Product product);

	Product getProductById(int id);

	List<Product> getProductList();

	void deleteProduct(int id);
}
