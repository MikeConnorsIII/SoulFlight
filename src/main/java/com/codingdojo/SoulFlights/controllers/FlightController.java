package com.codingdojo.SoulFlights.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.SoulFlights.models.Flight;
import com.codingdojo.SoulFlights.models.User;
import com.codingdojo.SoulFlights.services.FlightService;
import com.codingdojo.SoulFlights.services.UserService;





@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired 
	private UserService userService;

	// Display flight form
	@GetMapping("/flights/new")
	public String showFlightForm(Model model, HttpSession session) {

		model.addAttribute("newFlight", new Flight());

		if (session.getAttribute("userId") == null) {
			return "redirect:/home";
		}

		return "newFlight.jsp";
	}

	// process flight submission
	@PostMapping("/flights/new")
	public String processFlightForm(@Valid @ModelAttribute("newFlight") Flight flight, BindingResult result,
			Model model, HttpSession session) {
		
		if (result.hasErrors()) {
			model.addAttribute("newFlight", new Flight());
			return "newFlight.jsp";
		} else {
			flightService.createFlight(flight, result);
			return "redirect:/home";
		}

	}

	// Edit Flight
	// Get method to show our edit form
	@GetMapping("/flights/edit/{id}")
	public String ShowEditFlightForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		Flight flight = flightService.findOneFlight(id);
		model.addAttribute("flight", flight);

//		if (flight.getReader().getId() != (Long) session.getAttribute("userId")) {
//			return "redirect:/home";
//		}

		return "editFlight.jsp";

	}

	// process flight edit form using data binding
	@PutMapping("/flights/edit/{id}")
	public String editFlight(@Valid @ModelAttribute("flight") Flight flight, BindingResult result) {

		if (result.hasErrors()) {
			return "editFlight.jsp";
		} else {
			flightService.editFlight(flight);
			return "redirect:/home";
		}

	}

	// Show One flight
	@GetMapping("/flights/{id}")
	public String showFlight(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Flight flight = flightService.findOneFlight(id);
		model.addAttribute("flight", flight);
		User singleUser = userService.findOneUser((Long) session.getAttribute("userId"));
		model.addAttribute("user", singleUser);
		return "oneFlight.jsp";
	}

	// Delete a flight and redirect to dash board
	@DeleteMapping("flights/delete/{id}")
	public String deleteDonatuion(@PathVariable("id") Long id) {
		flightService.deleteFlight(id);
		return "redirect:/home";
	}
}
