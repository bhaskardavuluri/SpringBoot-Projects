package com.example.Restaurant_Management.repository;

import com.example.Restaurant_Management.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
