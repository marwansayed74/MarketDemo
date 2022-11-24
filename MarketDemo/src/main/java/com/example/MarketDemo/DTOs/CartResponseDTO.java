package com.example.MarketDemo.DTOs;

public class CartResponseDTO {
    private Long TotalPrice;

    public CartResponseDTO() {
    }

    public CartResponseDTO(Long totalPrice) {
        TotalPrice = totalPrice;
    }

    public Long getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        TotalPrice = totalPrice;
    }
}
