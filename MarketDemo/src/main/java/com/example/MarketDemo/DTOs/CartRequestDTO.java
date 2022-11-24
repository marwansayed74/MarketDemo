package com.example.MarketDemo.DTOs;

public class CartRequestDTO {
    private Long TotalPrice;

    public CartRequestDTO() {
    }

    public CartRequestDTO(Long totalPrice) {
        TotalPrice = totalPrice;
    }

    public Long getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        TotalPrice = totalPrice;
    }
}
