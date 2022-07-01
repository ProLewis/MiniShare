package com.cody.miniShare.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cody.miniShare.models.LoginUser;
import com.cody.miniShare.models.User;
import com.cody.miniShare.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	//Register and Login
	public User register(User newUser, BindingResult result) {
		//Checks to see if email already exists
		if (repo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email is already in use");
		}
		//Checks to make sure passwords match
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Password and Confirm Password must match");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);
		return repo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		//Cuts down on multiple errors being called
		if (result.hasErrors()) {
			return null;
		}
		
		//Checks to see if email exists for a user
		Optional<User> optUser = repo.findByEmail(newLogin.getEmail());
		if ( !optUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials");
			return null;
		}
		//Checks hashed pw to see if it matches
		User user = optUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials");
			return null;
		}
		return user;
	}
	
	//Read
	public User getOne(Long id) {
		return repo.findById(id).orElse(null);
	}
}
