package com.emusicstore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pborsoni
 *
 */
@Controller
public class HomeController {

	private static final String ROLE_ADMIN = "ROLE_ADMIN";
	private static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/home")
	public String myHome() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean isAnonymous = authentication.getAuthorities().stream()
				.anyMatch(a -> a.getAuthority().equals(ROLE_ANONYMOUS));

		if (!isAnonymous) {

			boolean isAdmin = authentication.getAuthorities().stream()
					.anyMatch(a -> a.getAuthority().equals(ROLE_ADMIN));

			if (isAdmin) {
				return "redirect:/admin";
			} else {
				// TODO: change this later, when the security is implemented in
				// jsp files we can check the ROLE_USER and add a nav bar to the
				// Cart page. Should change the home page as productList
				return "redirect:/customer/cart";
			}
		}

		return "redirect:/";
	}

}
