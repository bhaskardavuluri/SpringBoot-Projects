package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.dto.StudentDto;
import com.example.SpringBootDemo.entity.Student;
import com.example.SpringBootDemo.service.Impl.StudentServiceImpl;
import com.example.SpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
        StudentDto saveStudent = service.createStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student>findstudent(@PathVariable Long id){
        Student s=service.getStudent(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updatestudent(@PathVariable Long id ,@RequestBody StudentDto studentDto){
        StudentDto updateStudent=service.updateStudent(id,studentDto);
        return ResponseEntity.ok(updateStudent); //one way
        //return new ResponseEntity<>(updateStudent,HttpStatus.ok);//second way

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String>deletestudent(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok("student deleted successfully");
    }
}