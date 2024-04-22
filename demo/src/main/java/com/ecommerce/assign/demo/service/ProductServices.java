package com.ecommerce.assign.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.ecommerce.assign.demo.model.Product;
import com.ecommerce.assign.demo.repository.CreateProductRepository;
import com.ecommerce.assign.demo.request.ProductRequest;

@Service
public class ProductServices {
		
	private CreateProductRepository productRepository;
	
//	public ProductService()
	public ProductServices(CreateProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product createProduct(ProductRequest pr) {
		Product temProduct = new Product();
		temProduct.setId(pr.getId());
		temProduct.setImageUrl(pr.getImageUrl());
		temProduct.setQuantity(pr.getQuantity());
		temProduct.setTitle(pr.getTitle());
		temProduct.setDescription(pr.getDescription());
		temProduct.setBrand(pr.getBrand());
		temProduct.setPrice(pr.getPrice());
		temProduct.setDiscountPrice(pr.getDiscountPrice());
		
		return productRepository.save(temProduct);
	}
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
	
	public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
	
	public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
