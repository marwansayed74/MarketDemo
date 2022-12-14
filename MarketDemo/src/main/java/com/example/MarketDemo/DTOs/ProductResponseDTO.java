package com.example.MarketDemo.DTOs;

public class ProductResponseDTO {

    private String name;
    private Long price;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String name, Long price) {
        this.name = name;
        this.price = price;
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
}
