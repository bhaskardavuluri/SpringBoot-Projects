package com.example.Library_Management.repository;

import com.example.Library_Management.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
