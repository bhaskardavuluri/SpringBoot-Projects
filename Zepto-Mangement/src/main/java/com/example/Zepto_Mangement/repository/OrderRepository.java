package com.example.Zepto_Mangement.repository;

import com.example.Zepto_Mangement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
