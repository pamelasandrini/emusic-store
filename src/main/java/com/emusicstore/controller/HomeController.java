package com.emusicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

/**
 * @author pborsoni
 *
 */
@Controller
public class HomeController {

	@Autowired
	private ProductDao dao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model) {

		List<Product> productList = dao.getAllProducts();
		model.addAttribute("productList", productList);

		return "productList";
	}

	@RequestMapping("/productList/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		Product product = dao.getProductById(id);

		if (product != null) {
			model.addAttribute(product);
			return "viewProduct";

		} else {
			return "404";
		}
	}

}
