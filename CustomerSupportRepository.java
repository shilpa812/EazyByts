package com.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM.entity.CustomerSupport;

public interface CustomerSupportRepository extends JpaRepository<CustomerSupport, Long> {
}
