package com.example.MarketDemo.Services;

import com.example.MarketDemo.DTOs.ProductRequestDTO;
import com.example.MarketDemo.DTOs.ProductResponseDTO;
import com.example.MarketDemo.Repositorys.ProductRepository;
import com.example.MarketDemo.modules.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public  Product product;
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequestDTO productRequestDTO) {
        Product product =new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());

        productRepository.save(product);
    }

    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());

        return productResponseDTO;
    }

    public void deleteProduct(Long id) {
        boolean exists= productRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("product with id "+ id +" does not exists");
        }
        productRepository.deleteById(id);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("product with id" + id + " does not exists"));
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        productRepository.save(product);
    }
}
