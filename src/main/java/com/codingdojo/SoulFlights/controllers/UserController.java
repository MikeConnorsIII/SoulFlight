package com.codingdojo.SoulFlights.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.SoulFlights.models.LoginUser;
import com.codingdojo.SoulFlights.models.User;
import com.codingdojo.SoulFlights.services.FlightService;
import com.codingdojo.SoulFlights.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FlightService flightService;


	//Route to show home page after user has registered or logged in
	@GetMapping("/home")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("userName") == null) {
			return "redirect:/";
		}
		model.addAttribute("flightList", flightService.findAllFlights());
		return "home.jsp";
	}

	//Route to show registration form
	@GetMapping("/")
	public String showRegPage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}

	//post route for registration matching registration action in form tag in jsp file
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,
			HttpSession session) {
		//registers the user vis the register method in service class
		User registeredUser = userService.register(user, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		} else {
			session.setAttribute("userName", registeredUser.getUserName());
			session.setAttribute("userId", registeredUser.getId());
			return "redirect:/home";
		}

	}

	//post route for login matching login action in form tag in jsp file
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User loginUser = userService.login(newLogin, result);
		
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}else {
			session.setAttribute("userName", loginUser.getUserName());
			session.setAttribute("userId", loginUser.getId());
			return "redirect:/home";
		}
		
		

	}

	// Log out
	@GetMapping("/logout")
	public String logOutUser(HttpSession session) {
		session.invalidate();
		//this will cancel the cookie
		return "redirect:/";

	}

}
