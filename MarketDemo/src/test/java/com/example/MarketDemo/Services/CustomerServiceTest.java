package com.example.MarketDemo.Services;

import com.example.MarketDemo.Repositorys.CustomerRepository;
import com.example.MarketDemo.modules.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService ;
    @Mock
    private CustomerRepository customerRepository;

    @Test
    void getCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer customer= new Customer();
        customer.setId(40L);
        customer.setFname("qq");
        customer.setLname("xx");
        customer.setAge(65);
        customer.setEmail("qw");
        customer.setPassword(687);
        customers.add(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> customers1 = customerService.getCustomer();
        assertEquals(customers,customers1);
    }

    @Test
    void getCustomerById() {
    }
}