package com.example.zamut.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String message;

	@Column(nullable = false)
	private LocalDate createdate;

	@Column(nullable = false)
	@Future
	private LocalDate expiredate;

	@Column(name = "selected", nullable = false)
	private Boolean isActive;

	public Message() {
	}
	
	public Message(String message, LocalDate createdate, @Future LocalDate expiredate, Boolean isActive) {
		super();
		this.message = message;
		this.createdate = createdate;
		this.expiredate = expiredate;
		this.isActive = isActive;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public LocalDate getExpiredate() {
		return expiredate;
	}

	public void setExpiredate(LocalDate expiredate) {
		this.expiredate = expiredate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", createdate=" + createdate + ", expiredate="
				+ expiredate + ", isActive=" + isActive + "]";
	}
	
	
}
