package com.example.MarketDemo.modules;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @OneToMany(mappedBy = "product")
    private List<ItemLine> itemline;

    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Long price, List<ItemLine> itemline) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemline = itemline;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", itemline=" + itemline + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<ItemLine> getItemline() {
        return itemline;
    }

    public void setItemline(List<ItemLine> itemline) {
        this.itemline = itemline;
    }
}
