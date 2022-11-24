package com.example.MarketDemo.DTOs;

public class ItemLineRequestDTO {
    private Long Quantity;

    public ItemLineRequestDTO() {
    }

    public ItemLineRequestDTO(Long quantity) {
        Quantity = quantity;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }
}
