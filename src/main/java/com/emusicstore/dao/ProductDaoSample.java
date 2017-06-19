package com.emusicstore.dao;

import java.util.ArrayList;
import java.util.List;

import com.emusicstore.model.Product;

/**
 * @author pborsoni
 *
 */
@Deprecated
public class ProductDaoSample {

	private List<Product> productList;

	public ProductDaoSample() {

		productList = new ArrayList<>();
		Product product = new Product(1);
		product.setProductName("Guitar1");
		product.setProductCategory("Instrument");
		product.setProductDescription("This is a fender strat guitar");
		product.setProductPrice(1200);
		product.setProductManufacturer("Fender");
		product.setProductStatus("active");
		product.setProductCondition("new");
		product.setUnitInStock(11);

		Product product2 = new Product(2);
		product2.setProductName("Record");
		product2.setProductCategory("Record");
		product2.setProductDescription("This is an awesome mix of 20th century!");
		product2.setProductPrice(25);
		product2.setProductManufacturer("EMI");
		product2.setProductStatus("active");
		product2.setProductCondition("new");
		product2.setUnitInStock(51);

		Product product3 = new Product(3);
		product3.setProductName("Speaker1");
		product3.setProductCategory("Accessory");
		product3.setProductDescription("This is a Polk Shelf Speaker!");
		product3.setProductPrice(355);
		product3.setProductCondition("new");
		product3.setProductStatus("Active");
		product3.setUnitInStock(9);
		product3.setProductManufacturer("Polk");

		productList.add(product);
		productList.add(product2);
		productList.add(product3);
	}

	public List<Product> getProductList() {

		return productList;
	}

	public Product getProductById(int id) {

		for (Product product : productList) {

			if (product.getId()== id) {
				return product;
			}
		}

		return null;
	}
}
