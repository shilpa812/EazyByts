package com.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRM.entity.Contact;

public interface CustomerRepository  extends JpaRepository<Contact, Integer> {

}
