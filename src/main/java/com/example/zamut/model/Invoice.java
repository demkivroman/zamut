package com.example.zamut.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The date can't be empty")
    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(mappedBy = "invoice")
    private Sum sum;
    
    @ManyToMany
    @JoinTable(
    		name = "Invoice_Item_Collaborator",
    		joinColumns = { @JoinColumn(name = "invoice_id") },
    		inverseJoinColumns = { @JoinColumn(name = "invoice_item_id") }
    )
    private Set<InvoiceItem> invItems = new HashSet<InvoiceItem>();

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
