package com.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}


