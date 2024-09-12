package com.CRM.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM.entity.Sale;
import com.CRM.repository.SaleRepository;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
    
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }
    
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }
    public Sale updateSale(Sale sale) {
        return saleRepository.save(sale);
    }
    
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}

    

