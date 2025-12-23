package com.example.Course_Details.repository;

import com.example.Course_Details.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
