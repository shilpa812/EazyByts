package com.CRM.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM.entity.CustomerSupport;
import com.CRM.repository.CustomerSupportRepository;

@Service
public class CustomerSupportService {
    @Autowired
    private CustomerSupportRepository customerSupportRepository;
    
    public List<CustomerSupport> getAllCustomerSupports() {
        return customerSupportRepository.findAll();
    }
    
    public CustomerSupport getCustomerSupportById(Long id) {
        return customerSupportRepository.findById(id).orElse(null);
    }
    public CustomerSupport createCustomerSupport(CustomerSupport customerSupport) {
        return customerSupportRepository.save(customerSupport);
    }
    
    public CustomerSupport updateCustomerSupport(CustomerSupport customerSupport) {
        return customerSupportRepository.save(customerSupport);
    }
    
    public void deleteCustomerSupport(Long id) {
        customerSupportRepository.deleteById(id);
    }
}

