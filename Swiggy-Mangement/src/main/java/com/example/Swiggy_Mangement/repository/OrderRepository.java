package com.example.Swiggy_Mangement.repository;

import com.example.Swiggy_Mangement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
