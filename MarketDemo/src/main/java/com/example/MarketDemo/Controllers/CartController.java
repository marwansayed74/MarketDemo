package com.example.MarketDemo.Controllers;
import com.example.MarketDemo.DTOs.AddLineToCartDTO;
import com.example.MarketDemo.DTOs.CartRequestDTO;
import com.example.MarketDemo.DTOs.CartResponseDTO;
import com.example.MarketDemo.Services.CartService;
import com.example.MarketDemo.modules.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/Cart")
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path ="{id}")
    public CartResponseDTO getCartById(@PathVariable Long id){
        return cartService.getCartById(id);
    }
    @GetMapping
    public List<Cart> getCart() {
        return cartService.getCart();
    }
//    @PostMapping(path ="/add")
//    public void  registerNewCart(@RequestBody CartRequestDTO cartRequestDTO) {
//        cartService.addCart();
//    }
    @DeleteMapping (path ="{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }
    @PutMapping(path ="{id}")
    public void updateCart(@PathVariable Long id,
                               @RequestBody CartRequestDTO cartRequestDTO){
        cartService.updateCart(id,cartRequestDTO);
    }

    @PostMapping(path ="/addLineToCart")
    public void  AddLineToCart(@RequestBody AddLineToCartDTO addLineToCartDTO) {
        cartService.AddLineToCart(addLineToCartDTO);
    }

}
