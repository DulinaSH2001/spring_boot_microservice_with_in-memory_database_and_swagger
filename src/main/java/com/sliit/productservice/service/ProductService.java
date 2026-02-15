package com.sliit.productservice.service;

import com.sliit.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * Create a new product with validation
     * 
     * @param product Product to create
     * @return Created product
     * @throws InvalidProductException if product data is invalid
     */
    Product createProduct(Product product);

    /**
     * Get all products
     * 
     * @return List of all products
     */
    List<Product> getAllProducts();

    /**
     * Get product by ID
     * 
     * @param id Product ID
     * @return Product if found
     * @throws ProductNotFoundException if product not found
     */
    Product getProductById(Long id);

    /**
     * Update existing product
     * 
     * @param id      Product ID
     * @param product Updated product data
     * @return Updated product
     * @throws ProductNotFoundException if product not found
     * @throws InvalidProductException  if product data is invalid
     */
    Product updateProduct(Long id, Product product);

    /**
     * Delete product by ID
     * 
     * @param id Product ID
     * @throws ProductNotFoundException if product not found
     */
    void deleteProduct(Long id);
}
