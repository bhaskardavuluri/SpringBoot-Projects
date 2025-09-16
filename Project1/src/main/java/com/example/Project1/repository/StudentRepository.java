package com.example.Project1.repository;

import com.example.Project1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByid(Long id);
    Student deleteByid(Long id);

}
