package com.boocrun.service;

import java.util.List;

import com.boocrun.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    
    Student saveStudent(Student student);

}
