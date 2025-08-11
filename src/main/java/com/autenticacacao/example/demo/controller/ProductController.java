package com.autenticacacao.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autenticacacao.example.demo.exceptions.NameAlreadyExistsException;
import com.autenticacacao.example.demo.exceptions.ProductNotExistsException;
import com.autenticacacao.example.demo.models.product.Product;
import com.autenticacacao.example.demo.models.product.ProductDto;
import com.autenticacacao.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductDto productDto) throws NameAlreadyExistsException {
		Product product = new Product();
		product = productDto.cast(product);
		
		service.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable Long id) throws ProductNotExistsException  {
		Product product = new Product();
		product = service.findProductById(id);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> products = service.findAllProducts();
		
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	
}
