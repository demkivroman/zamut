package com.example.zamut.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConsumerDTO {
	private String fullname;
	private String address;
	
	public ConsumerDTO() {
	}
	
	public ConsumerDTO(String fullname, String address) {
		this.fullname = fullname;
		this.address = address;
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
		return "DAOConsumer [fullname=" + fullname + ", address=" + address + "]";
	}
	
	
	
}
