package com.example.zamut.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Sum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The amount can't be empty")
    @Min(value = 0, message = "The amount must be greater than 0")
    @Column(nullable = false)
    private Double amount;

    private String message;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Sum() {
    }
    
    

    public Consumer getConsumer() {
		return consumer;
	}



	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}



	public Invoice getInvoice() {
		return invoice;
	}



	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "id=" + id +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                '}';
    }
}
