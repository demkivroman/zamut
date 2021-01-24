package com.example.zamut.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "sum_invoice")
public class SumInvoice {
	
	@EmbeddedId
	private SumInvoiceId id;
	
	@ManyToOne
	@MapsId("sumId")
	private Sum sum;
	
	@ManyToOne
	@MapsId("invoiceId")
	private InvoiceItem invoice;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int count;

	public SumInvoice() {
	}

	public SumInvoice(Sum sum, InvoiceItem invoice) {
		this.sum = sum;
		this.invoice = invoice;
		this.id = new SumInvoiceId(sum.getId(), invoice.getId());
	}

	public SumInvoiceId getId() {
		return id;
	}

	public void setId(SumInvoiceId id) {
		this.id = id;
	}

	public Sum getSum() {
		return sum;
	}

	public void setSum(Sum sum) {
		this.sum = sum;
	}

	public InvoiceItem getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceItem invoice) {
		this.invoice = invoice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
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
		SumInvoice other = (SumInvoice) obj;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (sum == null) {
			if (other.sum != null)
				return false;
		} else if (!sum.equals(other.sum))
			return false;
		return true;
	}
	
}
