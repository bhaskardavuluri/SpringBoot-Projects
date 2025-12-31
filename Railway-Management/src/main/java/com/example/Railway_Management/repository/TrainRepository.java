package com.example.Railway_Management.repository;

import com.example.Railway_Management.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Long> {
}
