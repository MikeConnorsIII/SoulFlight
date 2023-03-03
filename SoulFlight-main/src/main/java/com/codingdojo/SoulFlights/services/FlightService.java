package com.codingdojo.SoulFlights.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.SoulFlights.models.Flight;
import com.codingdojo.SoulFlights.repo.FlightRepository;


@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepo;

	// Create
	public Flight createFlight(Flight Flight, BindingResult result) {
		//verify no title is the same
//		Optional<Flight> optionalFlight = flightRepo.findByTitle(Flight.getTitle());
//		
//		if (optionalFlight.isPresent()) {
//			result.rejectValue("title", "unique", "Title has been taken");
//		}
//		if (result.hasErrors()) {
//			return null;
//		}
		
		flightRepo.save(Flight);
		return Flight;

	}
	
//	//many to many
//    // This has the same effect as above:
//    thisFlight.getUsers().add(thisFlight);	// add the category to this products's list of categories
//    flightRepository.save(thisUser);	// Save thisProduct, since you made changes to its category list.
//    //many to many


	// Edit
	public Flight editFlight(Flight flight) {
		return flightRepo.save(flight);

	}

	// Find All
	public List<Flight> findAllFlights() {
		return flightRepo.findAll();
	}

	// Find one
	public Flight findOneFlight(Long id) {
		Optional<Flight> optionalFlight = flightRepo.findById(id);

		if (optionalFlight.isPresent()) {
			return optionalFlight.get();
		} else {
			return null;
		}
	}

	// Delete
	public void deleteFlight(Long id) {
		flightRepo.deleteById(id);
	}
}
