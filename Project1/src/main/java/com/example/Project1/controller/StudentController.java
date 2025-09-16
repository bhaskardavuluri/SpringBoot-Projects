package com.example.Project1.controller;


import com.example.Project1.dto.StudentDto;
import com.example.Project1.entity.Student;
import com.example.Project1.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //this annotation is used for handling the whole controller class and also converting the
//java objects into json /xml objects ..
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl service;
    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDto>saveStudent(@RequestBody StudentDto studentDto){
        StudentDto saveStudent=service.saveStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id){
        Student student=service.getStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody StudentDto studentDto){
        StudentDto studentDto1=service.updateStudent(id,studentDto);
        return new ResponseEntity<>(studentDto1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteStudent(id);
        return ResponseEntity.ok("Student is deleted successfully");
    }

}
