package com.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CRM.entity.CustomerSupport;
import com.CRM.serviceImpl.CustomerSupportService;

@Controller
public class CustomerSupportController {
    @Autowired
    private CustomerSupportService customerSupportService;
    
    @GetMapping("/customer-supports")
    public String getAllCustomerSupports(Model model) {
        List<CustomerSupport> customerSupports = customerSupportService.getAllCustomerSupports();
        model.addAttribute("customerSupports", customerSupports);
        return "customer-supports";
    }
    
    @GetMapping("/customer-supports/{id}")
    public String getCustomerSupportById(@PathVariable Long id, Model model) {
        CustomerSupport customerSupport = customerSupportService.getCustomerSupportById(id);
        model.addAttribute("customerSupport", customerSupport);
        return "customer-support";
    }
    
    @GetMapping("/customer-supports/create")
    public String createCustomerSupport(Model model) {
        model.addAttribute("customerSupport", new CustomerSupport());
        return "customer-support-create";
    }
    
    @PostMapping("/customer-supports")
    public String saveCustomerSupport(@ModelAttribute CustomerSupport customerSupport) {
        customerSupportService.createCustomerSupport(customerSupport);
        return "redirect:/customer-supports";
    }
    
    @GetMapping("/customer-supports/{id}/edit")
    public String editCustomerSupport(@PathVariable Long id, Model model) {
        CustomerSupport customerSupport = customerSupportService.getCustomerSupportById(id);
        model.addAttribute("customerSupport", customerSupport);
        return "customer-support-edit";
    }
    
    @PostMapping("/customer-supports/{id}")
    public String updateCustomerSupport(@PathVariable Long id, @ModelAttribute CustomerSupport customerSupport) {
        customerSupportService.updateCustomerSupport(customerSupport);
        return "redirect:/customer-supports";
    }
    
    @GetMapping("/customer-supports/{id}/delete")
    public String deleteCustomerSupport(@PathVariable Long id) {
    	 customerSupportService.deleteCustomerSupport(id);
         return "redirect:/customer-supports";
     }
 }

