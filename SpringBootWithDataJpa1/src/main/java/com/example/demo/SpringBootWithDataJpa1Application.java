package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.services.StudentService;
import com.example.demo.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootWithDataJpa1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootWithDataJpa1Application.class, args);

		StudentService stdService = context.getBean(StudentServiceImpl.class);
//---------------insert operation-----------------
//		Student std = new Student();
//		std.setName("Soumik");
//		std.setRollNo(102);
//		std.setMarks(95.5f);
//
//		boolean status = stdService.addStudentDetails(std);
//
//		if (status) {
//
//			System.out.println("Student inserted successfully");
//
//		} else {
//
//			System.out.println("Student not inserted due to some error");
//
//		}
//---------------------select operation 1---------------------
//		List<Student> stdList = stdService.getAllStdDetails();
//		for(Student std : stdList) {
//			System.out.println("Id : " +std.getId());
//			System.out.println("Name : " +std.getName());
//			System.out.println("RollNo : " +std.getRollNo());
//			System.out.println("Marks : " +std.getMarks());
//			
//			System.out.println("--------------------------------");
//		}

//-----------------------Select operation 2-------------------------
//		Student std = stdService.getStdDetails(2L);
//		if (std != null) {
//			System.out.println("Id : " + std.getId());
//			System.out.println("Name : " + std.getName());
//			System.out.println("RollNo : " + std.getRollNo());
//			System.out.println("Marks : " + std.getMarks());
//		} else {
//			System.out.println("Student not found...........!");
//		}

//-----------------------Update operation ---------------------
//		boolean status = stdService.updateStudentDetails(1L, 89.5f);
//		if (status) {
//			System.out.println("Student details updated Succesfully.....!");
//		} else {
//			System.out.println("Student details not updated due to some error....!");
//		}

//-------------------delete operation------------------------------
		boolean status = stdService.deleteStudentDetails(2L);
		if (status) {
			System.out.println("Student details deleted succesfullly.......!");
		} else {
			System.out.println("Student details not deleted due to some error.......!");
		}
	}

}
