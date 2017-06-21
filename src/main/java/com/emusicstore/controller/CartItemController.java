package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartItemController {

	/**
	 * Implicit uses the request mapping from the class
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping
	public String get(HttpServletRequest request) {
		// using the session id as the cart id
		//TODO: check if this is best practice
		return "redirect:/cart/" + request.getSession(true).getId();
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable("cartId") String cartId, Model model) {
		
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
