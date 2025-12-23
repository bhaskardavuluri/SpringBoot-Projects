package com.example.Product.Details.repository;

import com.example.Product.Details.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product ,Long> {
}
