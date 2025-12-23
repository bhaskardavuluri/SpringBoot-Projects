package com.example.Course_Details.controller;

import com.example.Course_Details.dto.CourseDto;
import com.example.Course_Details.entity.Course;
import com.example.Course_Details.service.impl.CourseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseImpl service;

    @PostMapping("/saveCourse")
    public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto) {
        CourseDto sc = service.saveCourse(courseDto);
        return new ResponseEntity<>(sc, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourse(@PathVariable Long id) {
        Course c = service.getCourse(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto>updateCourse(@PathVariable Long id,@RequestBody CourseDto courseDto){
    CourseDto c=service.updateCourse(id,courseDto);
    return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
service.deleteCourse(id);
return  ResponseEntity.ok("Course deleted Successfully");
    }
}
