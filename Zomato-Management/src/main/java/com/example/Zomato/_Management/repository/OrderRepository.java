package com.example.Zomato._Management.repository;

import com.example.Zomato._Management.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository< Order,Long> {

}
