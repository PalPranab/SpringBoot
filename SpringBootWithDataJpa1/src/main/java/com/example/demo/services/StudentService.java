package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.Student;

public interface StudentService {
	
	public boolean addStudentDetails(Student std);
	
	public List<Student> getAllStdDetails();
	
	public Student getStdDetails(long id);
	
	public boolean updateStudentDetails(long id, float marks);
	
	public boolean deleteStudentDetails(long id);

}
