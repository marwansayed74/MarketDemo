package com.example.MarketDemo.modules;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;
    private Long TotalPrice;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

@OneToMany(mappedBy = "cart")
    private List<ItemLine> itemline;

    public Cart() {
    }

    public Cart(Long id, Long totalPrice) {
        this.id = id;
        TotalPrice = totalPrice;
    }

    public Cart(Long id, Long totalPrice, Customer customer, List<ItemLine> itemline) {
        this.id = id;
        TotalPrice = totalPrice;
        this.customer = customer;
        this.itemline = itemline;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", totalPrice='" + TotalPrice + '\'' +
                ", customer='" + customer + '\'' +
                ", itemline=" + itemline + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        TotalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ItemLine> getItemline() {
        return itemline;
    }

    public void setItemline(List<ItemLine> itemline) {
        this.itemline = itemline;
    }
}
