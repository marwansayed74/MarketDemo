package com.example.MarketDemo.modules;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class ItemLine {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Long Quantity;

    @ManyToOne
    @JoinColumn(name = "Cart_id",referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    public ItemLine() {
    }

    public ItemLine(Long id, Long quantity) {
        this.id = id;
        this.Quantity = quantity;
    }

    public ItemLine(Long id, Long quantity, Cart cart) {
        this.id = id;
        this.Quantity = quantity;
        this.cart = cart;
    }

    public ItemLine(Long id, Long quantity, Cart cart, Product product) {
        this.id = id;
        Quantity = quantity;
        this.cart = cart;
        this.product = product;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", quantity='" + Quantity + '\'' +
                ", cart='" + cart + '\'' +
                ", product=" + product + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
