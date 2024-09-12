package com.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CRM.entity.Contact;
import com.CRM.serviceImpl.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl service;
	
	@GetMapping("/register")
	public String showReg() {
		return "customerRegister";
	}
	@PostMapping("/save")
	public String saveData(@ModelAttribute Contact customer,Model model) {
		 
		Integer id=service.saveCustomer(customer);
		String message = "Customer"+" "+id+" "+"created";
	model.addAttribute("message", message);
	return "customerRegister";
	
	}
	@GetMapping("/all")
	public String getAll(@RequestParam(required = false) String message,Model model ) {
	List<Contact> list = service.getAllCustomers();
	model.addAttribute("list", list);
	model.addAttribute("message", message);
	return "CustomerData";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,RedirectAttributes attributes) {
		service.deleteCustomer(id);
		attributes.addFlashAttribute("message", "Customer"+" "+id+" "+"deleted");
		return "redirect:all"; 
	}
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id ,Model model) {
	Contact cust = service.getOneCustomer(id);
	model.addAttribute("customer", cust);
	return "customerEdit";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Contact customer,RedirectAttributes attributes) {
		service.updateCustomer(customer);
		String message = "Customer"+" "+customer.getId()+" "+"updated";
		attributes.addAttribute("message", message);
		return "redirect:all";
	}
	
	
	
	
	
	
	
	

}
