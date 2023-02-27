package com.codingdojo.SoulFlights.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;



//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;

//Login user is not an entity, just a class to temporarily 
//hold the login details a user inputs

//dont add Entity cause were temporarily holding info for the 

public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 30 characters")
    private String password;
    
    public LoginUser() {}
    

    
}
