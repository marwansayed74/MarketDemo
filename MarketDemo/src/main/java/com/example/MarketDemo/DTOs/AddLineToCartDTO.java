package com.example.MarketDemo.DTOs;

public class AddLineToCartDTO {
    private Long cartId;
    private Long itemLineId;

    public Long getItemLineId() {
        return itemLineId;
    }

    public void setItemLineId(Long itemLineId) {
        this.itemLineId = itemLineId;
    }

    public AddLineToCartDTO() {
    }

    public AddLineToCartDTO(Long cartId, Long itemLineId) {
        this.cartId = cartId;
        this.itemLineId = itemLineId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
