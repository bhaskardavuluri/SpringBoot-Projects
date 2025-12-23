package com.example.Project1.service;

import com.example.Project1.dto.StudentDto;
import com.example.Project1.entity.Student;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);
    Student getStudent(Long id);
    StudentDto updateStudent(Long id,StudentDto studentDto);

    void deleteStudent(Long id);
}


