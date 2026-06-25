package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.User;

public interface UserService {

	public User createUser(User user);

	public List<User> getAllUsers();

	public Optional<User> getUserById(int id);
	
	public User updateUserDetails(int id , User user);
	
	public void deletUser(int id);
}
