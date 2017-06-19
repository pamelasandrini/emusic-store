package com.emusicstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, HttpSession session) {

		if (null != error) {
			model.addAttribute("error", "Invalid username or password!");
		}

		if (null != logout) {
			session.invalidate();
			model.addAttribute("logoutMsg", "You have been logout successfully.");
		}

		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		//TODO: check why this is not working in spring security config
		System.out.println("have been logout");
		session.invalidate();
		return "redirect:/login?logout";
	}
	
}
