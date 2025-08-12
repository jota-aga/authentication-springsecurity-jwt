package com.autenticacacao.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacacao.example.demo.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
}
