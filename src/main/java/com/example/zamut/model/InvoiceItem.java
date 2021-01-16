package com.example.zamut.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class InvoiceItem {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "The name can't be empty")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "The price can't be empty")
	@Min(value = 0, message = "The price must be greater than 0")
	@Column(nullable = false)
	private Double price;
	
	@NotBlank(message = "The price can't be empty")
	@Min(value = 0, message = "The price must be greater than 0")
	@Column(nullable = false)
	private Float size;
	
	@ManyToMany(mappedBy = "invItems")
	private Set<Sum> invoices = new HashSet<Sum>();

	public InvoiceItem() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "InvoiceItem [Id=" + Id + ", name=" + name + ", price=" + price + ", size=" + size + "]";
	}
	
	
}
