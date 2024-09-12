package com.CRM.service;

import java.util.List;

import com.CRM.entity.Contact;

public interface CustomerService {
	Integer saveCustomer(Contact cust);
	Contact getOneCustomer(Integer id);
	List<Contact> getAllCustomers();
	void updateCustomer(Contact cust);
	void deleteCustomer(Integer id);
	

}
