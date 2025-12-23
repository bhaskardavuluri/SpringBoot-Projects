package com.example.Product.Details.service;

import com.example.Product.Details.dto.ProductDto;
import com.example.Product.Details.entity.Product;
import com.example.Product.Details.repository.ProductRepository;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);
    Product getProduct(Long id);
    ProductDto updateProduct(Long id,ProductDto productDto);
    void deleteProduct(Long id);
}
