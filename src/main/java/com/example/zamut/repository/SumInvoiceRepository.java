package com.example.zamut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zamut.model.SumInvoice;

@Repository
public interface SumInvoiceRepository extends JpaRepository<SumInvoice, Long> {
}
