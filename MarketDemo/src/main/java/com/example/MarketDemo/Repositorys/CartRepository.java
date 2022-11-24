package com.example.MarketDemo.Repositorys;

import com.example.MarketDemo.modules.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
