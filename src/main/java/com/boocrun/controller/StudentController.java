package com.boocrun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
	model.addAttribute("student", studentService.getStudentById(id));
	return "edit_student";
    }
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, 
	    			@ModelAttribute("student") Student student, 
	    			Model model) {
	// get student from DB by id
	Student existingStudent = studentService.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	// Save updated student object
	studentService.updateStudent(existingStudent);
	return "redirect:/students";
    }
    
    // delete student
    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id) {
	studentService.deleteStudentById(id);
	return "redirect:/students";
    }

}
