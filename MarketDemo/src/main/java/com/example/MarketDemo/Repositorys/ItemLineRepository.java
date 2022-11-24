package com.example.MarketDemo.Repositorys;

import com.example.MarketDemo.modules.ItemLine;
import com.example.MarketDemo.modules.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLineRepository extends JpaRepository<ItemLine,Long> {
}
