package com.example.SpringBootDemo.service.Impl;

import com.example.SpringBootDemo.dto.StudentDto;
import com.example.SpringBootDemo.entity.Student;
import com.example.SpringBootDemo.repository.StudentRepository;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student s = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getMarks()
        );
        Student savedStudent = repository.save(s);
        StudentDto saveStudent = new StudentDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getMarks()
        );
        return saveStudent;
    }
    public Student getStudent(  Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found with the id "));

    }
    public StudentDto updateStudent(Long id,StudentDto studentDto){
        Student student=repository.findById(id)
                .orElseThrow(()->new RuntimeException("Student npt found with id "));
        student.setName(student.getName());
        student.setMarks(student.getMarks());
        Student updatedtudent=repository.save(student);
        return new StudentDto(
                updatedtudent.getId(),
                updatedtudent.getName(),
                updatedtudent.getMarks()
        );
    }
    public void deleteStudent(Long id ){
        Student student=repository.findById(id)
                .orElseThrow(()->new RuntimeException("student not found with id "));
        repository.delete(student);

    }
}
