package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
