package edu.uoengland.users.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoengland.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, UUID>{

}
