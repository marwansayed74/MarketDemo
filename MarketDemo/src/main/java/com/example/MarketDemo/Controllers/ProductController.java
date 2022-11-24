package com.example.MarketDemo.Controllers;

import com.example.MarketDemo.modules.Product;
import com.example.MarketDemo.DTOs.ProductRequestDTO;
import com.example.MarketDemo.DTOs.ProductResponseDTO;
import com.example.MarketDemo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/Product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path ="{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);

    }
    @GetMapping
    public List<Product> getAllProduct() {

        return productService.getAllProduct();
    }

    @PostMapping(path ="/add")
    public void  registerNewProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.addProduct(productRequestDTO);
    }


    @DeleteMapping (path ="{id}")
    public void deleteproduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(path ="{id}")
    public void updateProduct(@PathVariable Long id,
                               @RequestBody ProductRequestDTO productRequestDTO){
        productService.updateProduct(id,productRequestDTO);
    }




}
