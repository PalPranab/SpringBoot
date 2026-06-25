package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@SpringBootApplication
public class SpringBootProject4jdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootProject4jdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// -----------Insertion------------------
		// User user1 = new User("Pranab", "pranabpal349@gmail.com", "male", "bankura");
//		User user2 = new User("Babai", "babai264@gmail.com", "male", "pune");
//
//		boolean status = userDao.insertUser(user2);
//
//		if (status) {
//			System.out.println("User inserted successfully");
//		} else {
//			System.out.println("User not inserted due to some error");
//		}

		// -----------Updation----------------------------
//		User user = new User("Pranab", "pranabpal349@gmail.com", "male", "Bangalore");
//		boolean status = userDao.updateUser(user);
//		if (status) {
//			System.out.println("User updated successfully");
//		} else {
//			System.out.println("User not updated due to some error");
//		}

		// --------------------------Deletion-------------------------
		boolean status = userDao.deleteUserByEmailId("babai264@gmail.com");
		if (status) {
			System.out.println("User deleted successfully");
		} else {
			System.out.println("User not deleted due to some error");
		}
	}

}
