package com.example.MarketDemo.Controllers;

import com.example.MarketDemo.modules.Customer;
import com.example.MarketDemo.Services.CustomerService;
import com.example.MarketDemo.DTOs.CustomerRequestDTO;
import com.example.MarketDemo.DTOs.CustomerResponseDTO;
import com.example.MarketDemo.modules.ItemLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/Customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path ="{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }
    @PostMapping(path ="/add")
    public void  registerNewCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {

        customerService.addCustomer(customerRequestDTO);
    }
    @DeleteMapping (path ="{customerId}")
    public void deletecustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path ="{customerId}")
    public void updateCustomer(@PathVariable Long customerId,
                               @RequestBody CustomerRequestDTO customerRequestDTO){
        customerService.updateCustomer(customerId,customerRequestDTO);
    }




}

