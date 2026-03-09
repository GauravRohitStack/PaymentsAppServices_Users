package com.jbm.payments.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbm.payments.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}