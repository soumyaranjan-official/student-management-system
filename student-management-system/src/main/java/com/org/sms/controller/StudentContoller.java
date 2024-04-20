package com.org.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.sms.entity.Student;
import com.org.sms.service.StudentService;

@Controller
public class StudentContoller {

	private StudentService studentService;

	public StudentContoller(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students and return model and view

	@GetMapping("/students")
	public String listStudent(Model model) {

		model.addAttribute("students", studentService.getAllStduent());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student obj to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";

	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {

		model.addAttribute("student", studentService.getStudentById(id));

		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		
		//get student from database by id
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	
	//handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		 studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
