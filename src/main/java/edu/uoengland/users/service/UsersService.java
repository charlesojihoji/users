package edu.uoengland.users.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.uoengland.users.entity.Users;

public interface UsersService {

	public String createAUser(Users user);

	public List<Users> getAllUsers();

	public Optional<Users> getAUser(UUID userId);

	public void updateAUser(Users user, UUID userId);

	public void deleteAUser(UUID userId);
}
