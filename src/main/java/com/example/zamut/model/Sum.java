package com.example.zamut.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Sum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "The amount must be greater than 0")
    @Column(nullable = false)
    private Double amount;
    
    @Column(nullable = false)
    private LocalDate date;

    private String message;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @OneToMany(mappedBy = "sum") 
    private List<SumInvoice> items = new ArrayList<SumInvoice>();

    public Sum() {
    }
    
    

    public Sum(Double amount, LocalDate date, String message, Consumer consumer) {
		this.amount = amount;
		this.date = date;
		this.message = message;
		this.consumer = consumer;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Sum other = (Sum) obj;
		
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		
		return true;
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
