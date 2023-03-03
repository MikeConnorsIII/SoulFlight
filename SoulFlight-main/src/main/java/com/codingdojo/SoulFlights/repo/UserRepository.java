package com.codingdojo.SoulFlights.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SoulFlights.models.User;



//import com.codingdojo.bookClub.models.User;




@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
	List<User> findAll();

}
