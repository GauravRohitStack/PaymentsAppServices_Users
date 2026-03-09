package com.jbm.payments.app.service.impl;

import com.jbm.payments.app.entity.Product;
import com.jbm.payments.app.repository.ProductRepository;
import com.jbm.payments.app.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ==========================
    // Add Product
    // ==========================
    @Override
    public Product addProduct(Product product) {

        if (product.getPrice() <= 0) {
            throw new RuntimeException("Price must be greater than 0");
        }

        if (product.getStock() < 0) {
            throw new RuntimeException("Stock cannot be negative");
        }

        return productRepository.save(product);
    }

    // ==========================
    // Update Product
    // ==========================
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id)
                );

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());

        return productRepository.save(existingProduct);
    }

    // ==========================
    // Delete Product
    // ==========================
    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id)
                );

        productRepository.delete(product);
    }

    // ==========================
    // Get All Products
    // ==========================
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ==========================
    // Get Product By Id
    // ==========================
    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id)
                );
    }
}