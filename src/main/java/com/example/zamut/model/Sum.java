package com.example.zamut.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    
    @Column(nullable = false)
    private LocalDate date;

    private String message;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToMany
    @JoinTable(
    		name = "Invoice_Item_Collaborator",
    		joinColumns = { @JoinColumn(name = "sum_id") },
    		inverseJoinColumns = { @JoinColumn(name = "invoice_item_id") }
    )
    private Set<InvoiceItem> invItems = new HashSet<InvoiceItem>();

    public Sum() {
    }
    
    

    public Consumer getConsumer() {
		return consumer;
	}



	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
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
