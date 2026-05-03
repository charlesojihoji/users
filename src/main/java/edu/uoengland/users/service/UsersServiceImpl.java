package edu.uoengland.users.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoengland.users.entity.Users;
import edu.uoengland.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public String createAUser(Users user) {
		
		usersRepository.save(user);
		
		return "You have successfuly saved this user with a User ID of " + user.getUserId();
	}

	@Override
	public List<Users> getAllUsers() {

		return usersRepository.findAll();
	}

	@Override
	public Optional<Users> getAUser(UUID userId) {

		return usersRepository.findById(userId);
	}

	@Override
	public void updateAUser(Users user, UUID userId) {

		Optional<Users> oldUser = usersRepository.findById(userId);
		Users updatedUser = oldUser.get();
		
		updatedUser.setFullName(user.getFullName());
		updatedUser.setEmailAddress(user.getEmailAddress());
		updatedUser.setPhoneNumber(user.getPhoneNumber());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		
		usersRepository.save(updatedUser);
	}
	
}
