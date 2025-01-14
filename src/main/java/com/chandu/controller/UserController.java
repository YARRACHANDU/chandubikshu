package com.chandu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chandu.entity.Welcome;
import com.chandu.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public String login(@RequestBody Welcome welcome) {
		Welcome existingUser = userRepository.findByUsername(welcome.getUsername());
		if (existingUser != null && existingUser.getPassword().equals(welcome.getPassword())) {
			return "Login successful!";
		}
		return "Invalid username or password!";
	}

	@PostMapping("/register")
	public String register(@RequestBody Welcome welcome) {
		if (userRepository.findByUsername(welcome.getUsername()) != null) {
			return "Username already exists!";
		}
		userRepository.save(welcome);
		return "User registered successfully!";
	}

	@GetMapping("/user/{username}")
	public Welcome getUserDetails(@PathVariable String username) {
		Welcome welcome = userRepository.findByUsername(username);
		if (welcome != null) {
			return welcome;
		}
		return null; // or return an appropriate error message
	}

}
