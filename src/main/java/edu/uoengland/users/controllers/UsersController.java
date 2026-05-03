package edu.uoengland.users.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uoengland.users.entity.Users;
import edu.uoengland.users.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public String createAUser(@RequestBody Users user) {
		
		usersService.createAUser(user);
		
		return "You just created a User with a User ID of " + user.getUserId();
	}
	
	@GetMapping
	public List<Users> getAllUsers() {
		
		return usersService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<Users> getAUser(@PathVariable UUID userId) {
		
		return usersService.getAUser(userId);
	}
	
	@PutMapping("update/{userId}")
	public String updateAUser(@RequestBody Users user, @PathVariable UUID userId) {
		
		usersService.updateAUser(user, userId);
		
		return "The USer with a User ID of " + userId + " has been updated.";
	}
}
