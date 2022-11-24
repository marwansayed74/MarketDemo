package com.example.MarketDemo.DTOs;

public class ItemLineResponseDTO {
    private Long Quantity;

    public ItemLineResponseDTO(Long quantity) {
        Quantity = quantity;
    }

    public ItemLineResponseDTO() {
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }
}
