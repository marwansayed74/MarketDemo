package com.example.MarketDemo.DTOs;

public class AddProductToLineDTO {
    private Long productId;
    private Long Quantity;


    public AddProductToLineDTO() {
    }

    public AddProductToLineDTO(Long quantity, Long productId) {
        Quantity = quantity;
        this.productId = productId;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
