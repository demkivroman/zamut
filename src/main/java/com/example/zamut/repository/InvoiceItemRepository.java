package com.example.zamut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zamut.model.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
