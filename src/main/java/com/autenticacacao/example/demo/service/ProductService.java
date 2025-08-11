package com.autenticacacao.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autenticacacao.example.demo.exceptions.NameAlreadyExistsException;
import com.autenticacacao.example.demo.exceptions.ProductNotExistsException;
import com.autenticacacao.example.demo.models.product.Product;
import com.autenticacacao.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public void saveProduct(Product product) throws NameAlreadyExistsException {
		if(product.getId() == 0 && repo.findByName(product).isPresent()) {
			throw new NameAlreadyExistsException();
		}
		
		Optional<Product> productAux = repo.findByName(product);
		
		if(productAux.isPresent() && productAux.get().getId() != product.getId()) {
			throw new NameAlreadyExistsException();
		}
		
		repo.save(product);
	}
	
	public Product findProductById(Long id) throws ProductNotExistsException {
		Optional<Product> product = repo.findById(id);
		if(product.isEmpty()) {
			throw new ProductNotExistsException();
		}
		return product.get();
	}
	
	public List<Product> findAllProducts(){
		return repo.findAll();
	}
}
