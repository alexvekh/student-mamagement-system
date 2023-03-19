package com.boocrun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boocrun.entity.Student;
import com.boocrun.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
	    
	    Student student1 = new Student("Anderew", "Strong", "andrewstrong@gmail.com");
	    studentRepository.save(student1);
	    
	    Student student2 = new Student("Robert", "White", "whiterob@hotmail.com");
	    studentRepository.save(student2);
	    
	    Student student3 = new Student("David", "Scott", "davidscot@gmail.com");
	    studentRepository.save(student3);
	    
	    Student student4 = new Student("James", "Smith", "jsmith@gmail.com");
	    studentRepository.save(student4);
	    
	    Student student5 = new Student("John", "Williams", "jwillhn@yahoo.com");
	    studentRepository.save(student5);
	    
	    Student student6 = new Student("Michael", "Brown", "michaelbrown@gmail.com");
	    studentRepository.save(student6);
	    
	    Student student7 = new Student("Richard", "Garcia", "rgarcia@gmail.com");
	    studentRepository.save(student7);
	    
	    Student student8 = new Student("William", "Jackson", "willjackson@yahoo.com");
	    studentRepository.save(student8);
	    
	    Student student9 = new Student("Josef", "Anderson", "jos-anderson@gmail.com");
	    studentRepository.save(student9);
	    
	    Student student10 = new Student("Thomas", "Perez", "tomperezz@outlook.com");
	    studentRepository.save(student10);

	    Student student11 = new Student("Mark", "Carter", "markcarter@gmail.com");
	    studentRepository.save(student11);
	}
}
