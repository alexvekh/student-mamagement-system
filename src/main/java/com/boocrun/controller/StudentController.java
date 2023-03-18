package com.boocrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boocrun.entity.Student;
import com.boocrun.service.StudentService;

@Controller
public class StudentController {
    
    private StudentService studentService;

    public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
    }
    
    // handler method to handle student list and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
	model.addAttribute("students", studentService.getAllStudents());
	return "students";
	
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
	
	//create student object to ? (hold student from data)
	Student student = new Student();
	model.addAttribute("student", student);
	return "create_student";
    }
    
    @PostMapping("/students")
    public String seveStudent(@ModelAttribute("student") Student student) {
	
	studentService.saveStudent(student);
	return "redirect:/students";
	
    }

}
