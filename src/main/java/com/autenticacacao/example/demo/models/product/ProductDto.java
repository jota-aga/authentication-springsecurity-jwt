package com.autenticacacao.example.demo.models.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDto {
	@NotNull(message = "Name is null.")
	private String name;
	@Min(value = 0)
	private int quantity;
	@Positive(message="price must be positive")
	private double price;
	
	public ProductDto(String name, int quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Product cast(Product product) {
		product.setName(this.name);
		product.setPrice(this.price);
		product.setQuantity(this.quantity);
		
		return product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
