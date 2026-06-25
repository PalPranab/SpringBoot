package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean rgisterUser(User user) {

		try {

			userRepository.save(user);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loginUser(String email, String password) {

		User validUser = userRepository.findByEmail(email);

		if (validUser != null && validUser.getPassword().equals(password)) {
			return validUser;
		}
		return null;
	}

}
