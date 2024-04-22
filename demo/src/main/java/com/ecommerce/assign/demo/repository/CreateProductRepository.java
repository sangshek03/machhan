package com.ecommerce.assign.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.assign.demo.model.Product;

public interface CreateProductRepository extends JpaRepository<Product, Long> {
}
