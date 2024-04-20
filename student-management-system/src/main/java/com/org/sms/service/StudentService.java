package com.org.sms.service;

import java.util.List;

import com.org.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStduent();

	Student saveStudent(Student student);

	Student getStudentById(int id);

	Student updateStudent(Student student);
	
	void deleteStudentById(int id);
}
