package com.example.MarketDemo.Services;

import com.example.MarketDemo.modules.Customer;
import com.example.MarketDemo.Repositorys.CustomerRepository;
import com.example.MarketDemo.DTOs.CustomerRequestDTO;
import com.example.MarketDemo.DTOs.CustomerResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final CartService cartService;

    public CustomerService(CustomerRepository customerRepository, CartService cartService) {
        this.customerRepository = customerRepository;
        this.cartService = cartService;
    }

    public void addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer =new Customer();
        customer.setFname(customerRequestDTO.getFname());
        customer.setLname(customerRequestDTO.getLname());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setAge(customerRequestDTO.getAge());

        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent())
        {
            throw new IllegalStateException("Email Taken");
        }
        cartService.addCart(customer);
        customerRepository.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }


    public void deleteCustomer(Long customerId) {
        boolean exists= customerRepository.existsById(customerId);
        if (!exists){
            throw new IllegalStateException("customer with id "+ customerId +" does not exists");
        }
        customerRepository.deleteById(customerId);
    }
    @Transactional
    public void updateCustomer(Long customerId, CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new IllegalStateException("customer with id" + customerId + " does not exists"));
        customer.setFname(customerRequestDTO.getFname());
        customer.setLname(customerRequestDTO.getLname());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setAge(customerRequestDTO.getAge());
        customer.setPassword(customerRequestDTO.getPassword());

        customerRepository.save(customer);

    }

    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setFname(customer.getFname());
        customerResponseDTO.setLname(customer.getLname());
        customerResponseDTO.setEmail(customer.getEmail());
        customerResponseDTO.setAge(customer.getAge());
        return customerResponseDTO;
    }



}

