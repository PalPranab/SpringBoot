package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {

	public boolean rgisterUser(User user);
	public User loginUser(String email, String password);
}
