package com.example.zamut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SumInvoiceId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "sum_id")
	private Long sumId;
	
	@Column(name = "invoice_id")
	private Long invoiceId;
	

	public SumInvoiceId() {
	}
	

	public SumInvoiceId(Long sumId, Long invoiceId) {
		super();
		this.sumId = sumId;
		this.invoiceId = invoiceId;
	}

	public Long getSumId() {
		return sumId;
	}


	public Long getInvoiceId() {
		return invoiceId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		result = prime * result + ((sumId == null) ? 0 : sumId.hashCode());
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
		
		SumInvoiceId other = (SumInvoiceId) obj;
		
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		
		if (sumId == null) {
			if (other.sumId != null)
				return false;
		} else if (!sumId.equals(other.sumId))
			return false;
		
		return true;
	}
	
}
