package com.codingdojo.SoulFlights.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.SoulFlights.models.LoginUser;
import com.codingdojo.SoulFlights.models.User;
import com.codingdojo.SoulFlights.repo.UserRepository;






//import com.codingdojo.bookClub.models.Book;




//import model

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// create a user
	public User register(User newUser, BindingResult result) {
		//verify no email is the same
		Optional<User> optionaluser = userRepo.findByEmail(newUser.getEmail());

		
		if (optionaluser.isPresent()) {
			result.rejectValue("email", "unique", "This email already exists");
		} //error message if present

		
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "Your password does not match");
		} //confirm pass with this here

		
		if (result.hasErrors()) {
			return null;
		}

		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		//prevent the password from saving as is by bcrypting it here
		
		newUser.setPassword(hashed);

		
		userRepo.save(newUser);

		return newUser;
	}

	public User login(LoginUser loginUser, BindingResult result) {
		
		Optional<User> optionaluser = userRepo.findByEmail(loginUser.getEmail());

		//check for email in sql
		if (!optionaluser.isPresent()) {
			result.rejectValue("email", "unavailable", "Invalid credentials");
			return null;
		}
		
	
		User user = optionaluser.get();
		
		
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "matches", "Invalid Password!");
    	} //verify pass w sql
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	// Find All
		public List<User> findAllUsers() {
			return userRepo.findAll();
		}

	public User findOneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

}
