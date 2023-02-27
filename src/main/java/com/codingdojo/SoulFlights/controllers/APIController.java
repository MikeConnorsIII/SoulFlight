package com.codingdojo.SoulFlights.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.travel.models.Travel;
import com.codingdojo.travel.services.TravelService;


@RestController
@RequestMapping("/api")
public class APIController {

	private final TravelService travelService;

	public APIController(TravelService travelService) {
		this.travelService = travelService;
	}
	
	// get all travel expenses route
	@GetMapping("/travels")
	public List<Travel> getAllTravel() {
		return travelService.allTravel();	
		}
	
	// create travel expense route
	@PostMapping("/travels")
	public Travel createTravel(
		@RequestParam("expense") String expense,
		@RequestParam("vendor") String vendor,
		@RequestParam("amount") Double amount,
		@RequestParam("description") String description
		) {
		Travel newTravel = new Travel(expense, vendor, amount, description);
		return travelService.addTravel(newTravel);
		}
	
	//Get One travel
	@GetMapping("/travels/{id}")
	public Travel getOneTravel(@PathVariable("id")Long id) {
		//getTravel or returnTravel or getOneTravel
		return travelService.oneTravel(id);
	}
	
	//Update---> findOne and create
	@PutMapping("/travels/{id}")
	public Travel editTravelProcess(
			@PathVariable("id")Long id,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Double amount,
			@RequestParam("description") String description
			) {
		Travel foundTravel = travelService.oneTravel(id);
		foundTravel.setExpense(expense);
		foundTravel.setVendor(vendor);
		foundTravel.setAmount(amount);
		foundTravel.setDescription(description);
		return travelService.updateTravel(foundTravel);
	}
	
	@DeleteMapping("/travels/{id}")
	public void deleteTravel(@PathVariable("id")Long id) {
		travelService.deleteTravel(id);
	}
}