package com.sliit.productservice.service.impl;

import com.sliit.productservice.entity.Product;
import com.sliit.productservice.exception.InvalidProductException;
import com.sliit.productservice.exception.ProductNotFoundException;
import com.sliit.productservice.repository.ProductRepository;
import com.sliit.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        // Business validation
        validateProduct(product);

        // Check for duplicate product name
        if (product.getName() != null && productRepository.findByName(product.getName()).isPresent()) {
            throw new InvalidProductException("Product with name '" + product.getName() + "' already exists");
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // Check if product exists
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        // Business validation
        validateProduct(product);

        // Check for duplicate name (excluding current product)
        if (product.getName() != null) {
            productRepository.findByName(product.getName()).ifPresent(p -> {
                if (!p.getId().equals(id)) {
                    throw new InvalidProductException("Product with name '" + product.getName() + "' already exists");
                }
            });
        }

        // Update fields
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        // Check if product exists
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        productRepository.deleteById(id);
    }

    /**
     * Validate product data
     * 
     * @param product Product to validate
     * @throws InvalidProductException if validation fails
     */
    private void validateProduct(Product product) {
        if (product == null) {
            throw new InvalidProductException("Product cannot be null");
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new InvalidProductException("Product name is required");
        }

        if (product.getPrice() == null) {
            throw new InvalidProductException("Product price is required");
        }

        if (product.getPrice() <= 0) {
            throw new InvalidProductException("Product price must be positive");
        }
    }
}
