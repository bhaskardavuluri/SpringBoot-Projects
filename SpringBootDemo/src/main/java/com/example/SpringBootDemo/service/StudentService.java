package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.dto.StudentDto;
import com.example.SpringBootDemo.entity.Student;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    Student getStudent(Long id );
    StudentDto updateStudent(Long id ,StudentDto studentDto);
     void  deleteStudent(Long id);
}
