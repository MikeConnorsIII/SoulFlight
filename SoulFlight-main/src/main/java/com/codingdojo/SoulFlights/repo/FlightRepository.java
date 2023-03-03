package com.codingdojo.SoulFlights.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SoulFlights.models.Flight;



@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
	List<Flight> findAll(); //find all donations
	
//	Optional<Flight> findByTitle(String title)
//	Optional<Flight> findById(Long id)
	
}
