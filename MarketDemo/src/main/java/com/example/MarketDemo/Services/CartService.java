package com.example.MarketDemo.Services;

import com.example.MarketDemo.DTOs.AddLineToCartDTO;
import com.example.MarketDemo.DTOs.CartRequestDTO;
import com.example.MarketDemo.DTOs.CartResponseDTO;
import com.example.MarketDemo.Repositorys.CartRepository;
import com.example.MarketDemo.Repositorys.ItemLineRepository;
import com.example.MarketDemo.modules.Cart;
import com.example.MarketDemo.modules.Customer;
import com.example.MarketDemo.modules.ItemLine;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final ItemLineRepository itemLineRepository;
    public CartService(CartRepository cartRepository, ItemLineRepository itemLineRepository) {
        this.cartRepository = cartRepository;
        this.itemLineRepository = itemLineRepository;
    }


    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public void addCart(Customer customer) {
        Cart cart =new Cart();
        cart.setCustomer(customer);
        cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        boolean exists= cartRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("cart with id "+ id +" does not exists");
        }
        cartRepository.deleteById(id);
    }
    @Transactional
    public void updateCart(Long id, CartRequestDTO cartRequestDTO) {
        Cart cart = cartRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("cart with id" + id + " does not exists"));
        cart.setTotalPrice(cartRequestDTO.getTotalPrice());
        cartRepository.save(cart);
    }

    public CartResponseDTO getCartById(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(RuntimeException::new);
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setTotalPrice(cart.getTotalPrice());;
        return cartResponseDTO;
    }

    public void AddLineToCart(AddLineToCartDTO addLineToCartDTO) {
        Cart cart =cartRepository.findById(addLineToCartDTO.getCartId()).orElseThrow(RuntimeException::new);
        ItemLine itemLine =itemLineRepository.findById(addLineToCartDTO.getItemLineId()).orElseThrow(RuntimeException::new);
        cart.getItemline().add(itemLine);
        itemLine.setCart(cart);
        itemLineRepository.save(itemLine);
        cartRepository.save(cart);
    }
}
