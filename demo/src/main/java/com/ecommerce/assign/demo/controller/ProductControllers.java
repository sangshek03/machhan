package com.ecommerce.assign.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.assign.demo.model.Product;
import com.ecommerce.assign.demo.request.ProductRequest;
import com.ecommerce.assign.demo.service.ProductServices;

@RestController
@CrossOrigin(origins = "*")
public class ProductControllers {
	
    private ProductServices productService;
	
	public ProductControllers(ProductServices productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/create/product")
    public Product createProduct(@RequestBody ProductRequest pr) {
		return productService.createProduct(pr);
    }
	
	@GetMapping(path = "/all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
	
	@GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
	@DeleteMapping("/remove-product-{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product deleted successfully");
    }

}
