package com.example.Project1.service.impl;

import com.example.Project1.dto.StudentDto;
import com.example.Project1.entity.Student;
import com.example.Project1.repository.StudentRepository;
import com.example.Project1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getMarks()
        );
        Student savedStudent = repository.save(student);
        StudentDto saveStudent = new StudentDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getMarks()
        );
        return saveStudent;
    }

    @Override
    public Student getStudent(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student=repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id"+id));
                student.setName(studentDto.getName());
                student.setMarks(studentDto.getMarks());
                Student updatedStudent=repository.save(student);
                return new StudentDto(
                        updatedStudent.getId(),
                        updatedStudent.getName(),
                        updatedStudent.getMarks()
                );

    }
    @Override
    public void deleteStudent(Long id){
        Student student=repository.findByid(id);
                      // .orElseThrow(()->new RuntimeException("Student Not Found",+id));
        repository.delete(student);
    }

}
