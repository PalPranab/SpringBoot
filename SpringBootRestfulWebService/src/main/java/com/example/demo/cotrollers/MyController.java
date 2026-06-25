package com.example.demo.cotrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {

		return userService.createUser(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsersDetails() {

		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {

		User user = userService.getUserById(id).orElse(null);
		if (user != null) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUsersById(@PathVariable int id, @RequestBody User newUser) {

		User updatedUser = userService.updateUserDetails(id, newUser);

		if (updatedUser != null) {

			return ResponseEntity.ok().body(newUser);

		} else {

			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUsersById(@PathVariable int id) {

		userService.deletUser(id);

		return ResponseEntity.noContent().build();
	}

}
