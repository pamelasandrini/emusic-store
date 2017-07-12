package com.emusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> productList = service.getProductList();
		model.addAttribute("productList", productList);

		return "productList";
	}

	@RequestMapping("/productList/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		Product product = service.getProductById(id);

		if (product != null) {
			model.addAttribute(product);

			// TODO: check if need to pass 'role' param to the View
			return "viewProduct";

		} else {
			return "404";
		}
	}
}
