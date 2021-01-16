package com.example.zamut.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;


@Entity
public class Consumer {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
    
	@NotBlank(message = "The full name can't be empty")
	@Size(min = 3, max = 50)
	@Column(nullable = false, unique = true)
	private String fullname;

	@NotBlank(message = "The full name can't be empty")
	@Column(nullable = false, unique = true)
	private String address;

	@OneToMany(mappedBy = "consumer")
	private List<Sum> sums;

	@OneToMany(mappedBy = "consumer")
	private List<Logger> loggers;

	
	public Consumer() {
		super();
	}
	
	
	public Consumer(String fullname, String address) {
		this.fullname = fullname;
		this.address = address;
	}
	
	public Consumer(long id, String fullname, String address) {
		this.Id = id;
		this.fullname = fullname;
		this.address = address;
	}

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Consumer [Id=" + Id + ", FullName=" + fullname + ", Adrress=" + address + "]";
	}
	
	
}
