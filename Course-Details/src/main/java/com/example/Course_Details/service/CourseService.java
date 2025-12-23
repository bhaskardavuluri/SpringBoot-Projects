package com.example.Course_Details.service;

import com.example.Course_Details.dto.CourseDto;
import com.example.Course_Details.entity.Course;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);
    Course getCourse(Long id);
    CourseDto updateCourse(Long id,CourseDto courseDto);
    void deleteCourse(Long id);
}
