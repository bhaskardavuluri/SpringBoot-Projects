package com.example.Product.Details.service.ServiceImpl;

import com.example.Product.Details.dto.ProductDto;
import com.example.Product.Details.entity.Product;
import com.example.Product.Details.repository.ProductRepository;
import com.example.Product.Details.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getBrand()
        );
        Product savedProduct = repository.save(product);
        ProductDto saveProduct = new ProductDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getBrand()
        );
        return saveProduct;
    }

    public Product getProduct(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id" + id));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id:" + id));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Product updatedProduct = repository.save(product);
        return new ProductDto(
                updatedProduct.getId(),
                updatedProduct.getName(),
                updatedProduct.getPrice(),
                updatedProduct.getBrand()
        );


    }
    public void deleteProduct(Long id){
Product product=repository.findById(id)
        .orElseThrow(()->new RuntimeException("Product not found"+id));
repository.delete(product);
    }
}


