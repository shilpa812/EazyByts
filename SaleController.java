package com.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CRM.entity.Sale;
import com.CRM.serviceImpl.SaleService;

@Controller
public class SaleController {
    @Autowired
    private SaleService saleService;
    
    @GetMapping("/sales")
    public String getAllSales(Model model) {
        List<Sale> sales = saleService.getAllSales();
        model.addAttribute("sales", sales);
        return "sales";
    }
    
    @GetMapping("/sales/{id}")
    public String getSaleById(@PathVariable Long id, Model model) {
        Sale sale = saleService.getSaleById(id);
        model.addAttribute("sale", sale);
        return "sales";
    }
    
    @GetMapping("/sales/create")
    public String createSale(Model model) {
        model.addAttribute("sale", new Sale());
        return "sale-create";
    }
    @PostMapping("/sales")
    public String saveSale(@ModelAttribute Sale sale) {
        saleService.createSale(sale);
        return "redirect:/sales";
    }
    
    @GetMapping("/sales/{id}/edit")
    public String editSale(@PathVariable Long id, Model model) {
        Sale sale = saleService.getSaleById(id);
        model.addAttribute("sale", sale);
        return "sale-edit";
    }
    @PostMapping("/sales/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute Sale sale) {
        saleService.updateSale(sale);
        return "redirect:/sales";
    }
    
    @GetMapping("/sales/{id}/delete")
    public String deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return "redirect:/sales";
    }
}


