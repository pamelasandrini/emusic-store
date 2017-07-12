package com.emusicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public List<Product> getProductList() {
		return dao.getProductList();
	}

	@Override
	public Product getProductById(int id) {
		return dao.getProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		dao.addProduct(product);

	}

	@Override
	public void editProduct(Product product) {
		dao.updateProduct(product);

	}

	@Override
	public void deleteProduct(int id) {
		dao.deleteProduct(id);
	}

}
