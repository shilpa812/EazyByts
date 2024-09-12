package com.CRM.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM.entity.Contact;
import com.CRM.repository.CustomerRepository;
import com.CRM.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
 @Autowired
	private CustomerRepository repo;
	@Override
	public Integer saveCustomer(Contact cust) {
		return  repo.save(cust).getId();
	}

	@Override
	public Contact getOneCustomer(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Contact> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public void updateCustomer(Contact cust) {
		repo.save(cust);
		
	}

	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
		
	}

}
