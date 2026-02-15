package com.sliit.productservice.repository;

import com.sliit.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides built-in methods:
    // - save(Product product)
    // - findAll()
    // - findById(Long id)
    // - deleteById(Long id)
    // - count()
    // - existsById(Long id)

    // You can add custom query methods here if needed
    // Custom query method to find product by name
    Optional<Product> findByName(String name);
}
