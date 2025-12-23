package com.example.Course_Details.service.impl;

import com.example.Course_Details.dto.CourseDto;
import com.example.Course_Details.entity.Course;
import com.example.Course_Details.repository.CourseRepository;
import com.example.Course_Details.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseImpl implements CourseService {
    @Autowired
    private CourseRepository repository;
    public CourseDto saveCourse(CourseDto courseDto){
        Course c=new Course(
                courseDto.getId(),
                courseDto.getCname(),
                courseDto.getFees()
        );
        Course savedCourse=repository.save(c);
        CourseDto sc=new CourseDto(
                savedCourse.getId(),
                savedCourse.getCname(),
                savedCourse.getFees()
        );
        return sc;
    }
    public Course getCourse(Long id){
return repository.findById(id)
        .orElseThrow(()->new RuntimeException("Course-Details does not found "+id));
    }
    public CourseDto updateCourse(Long id,CourseDto courseDto){
        Course c =repository.findById(id)
                .orElseThrow(()->new RuntimeException("course does not found with"+id));
        c.setCname(courseDto.getCname());
        c.setFees(courseDto.getFees());
Course updatedCourse=repository.save(c);
return new CourseDto(
        updatedCourse.getId(),
        updatedCourse.getCname(),
        updatedCourse.getFees()
);
    }
    public void deleteCourse(Long id){
        Course c=repository.findById(id)
                .orElseThrow(()->new RuntimeException("Course not found"+id));
        repository.delete(c);
    }
}
