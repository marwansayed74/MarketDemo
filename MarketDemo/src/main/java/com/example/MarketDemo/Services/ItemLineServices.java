package com.example.MarketDemo.Services;

import com.example.MarketDemo.DTOs.AddProductToLineDTO;
import com.example.MarketDemo.DTOs.ItemLineRequestDTO;
import com.example.MarketDemo.DTOs.ItemLineResponseDTO;
import com.example.MarketDemo.Repositorys.ItemLineRepository;
import com.example.MarketDemo.Repositorys.ProductRepository;
import com.example.MarketDemo.modules.ItemLine;
import com.example.MarketDemo.modules.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemLineServices {
    @Autowired
    private final ItemLineRepository itemLineRepository;
    @Autowired
    private final ProductRepository productRepository;

    public ItemLineServices(ItemLineRepository itemLineRepository, ProductRepository productRepository) {
        this.itemLineRepository = itemLineRepository;
        this.productRepository = productRepository;
    }

    public ItemLineResponseDTO getItemLineById(Long id) {
        ItemLine itemLine = itemLineRepository.findById(id).orElseThrow(RuntimeException::new);
        ItemLineResponseDTO itemLineResponseDTO = new ItemLineResponseDTO();
        itemLineResponseDTO.setQuantity(itemLine.getQuantity());
        return itemLineResponseDTO;
    }

    public List<ItemLine> getItemLine() {
        return itemLineRepository.findAll();
    }

    public void addItemLine(ItemLineRequestDTO itemLineRequestDTO) {
        ItemLine itemLine =new ItemLine();
        itemLine.setQuantity(itemLineRequestDTO.getQuantity());;
        itemLineRepository.save(itemLine);
    }

    public void deleteItemLine(Long id) {
        boolean exists= itemLineRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Item Line with id "+ id +" does not exists");
        }
        itemLineRepository.deleteById(id);
    }
    @Transactional
    public void updateItemLine(Long id, ItemLineRequestDTO itemLineRequestDTO) {
        ItemLine itemLine = itemLineRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("item line with id" + id + " does not exists"));
        itemLine.setQuantity(itemLineRequestDTO.getQuantity());
        itemLineRepository.save(itemLine);
    }


    public void addProductToLine(AddProductToLineDTO addProductToLineDTO) {
        ItemLine itemLine =new ItemLine();
        Product product = productRepository.findById(addProductToLineDTO.getProductId()).orElseThrow(RuntimeException::new);
        itemLine.setProduct(product);
        itemLine.setQuantity(addProductToLineDTO.getQuantity());
        itemLineRepository.save(itemLine);
    }

}
