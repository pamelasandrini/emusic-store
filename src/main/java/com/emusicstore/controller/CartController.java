package com.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	private CustomerService service;

	@RequestMapping
	public String getCartIdFromLoggedInUser(@AuthenticationPrincipal User activeUser) {

		Customer customer = service.getCustomerByUserName(activeUser.getUsername());

		int cartId = customer.getCart().getCartId();

		return "redirect:/customer/cart/" + cartId;
	}

	@RequestMapping("/{cartId}")
	public String getCart(@PathVariable(value = "cartId") int cartId, Model model) {

		model.addAttribute("cartId", cartId);

		return "cart";
	}

}
