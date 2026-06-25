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
	public boolean registerUser(User user) {
		boolean status = false;
		try {

			userRepository.save(user);
			status = true;

		} catch (Exception e) {

			e.printStackTrace();
			status = false;

		}
		return status;
	}

}
