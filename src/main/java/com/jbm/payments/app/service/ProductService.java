package com.jbm.payments.app.service;

import com.jbm.payments.app.entity.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getAllProducts();

    Product getProductById(Long id);
}