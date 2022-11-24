package com.example.MarketDemo.Controllers;

import com.example.MarketDemo.DTOs.AddProductToLineDTO;
import com.example.MarketDemo.DTOs.ItemLineRequestDTO;
import com.example.MarketDemo.DTOs.ItemLineResponseDTO;
import com.example.MarketDemo.Services.ItemLineServices;
import com.example.MarketDemo.Services.ProductService;
import com.example.MarketDemo.modules.ItemLine;
import com.example.MarketDemo.modules.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/ItemLine")
public class ItemLineController {

    @Autowired
    private final ItemLineServices itemLineServices;

    public ItemLineController(ItemLineServices itemLineServices) {
        this.itemLineServices = itemLineServices;
    }

    @GetMapping(path ="{id}")
    public ItemLineResponseDTO getItemLineById(@PathVariable Long id){
        return itemLineServices.getItemLineById(id);
    }
    @GetMapping
    public List<ItemLine> getItemLine() {
        return itemLineServices.getItemLine();
    }


    @PostMapping(path ="/add")
    public void  registerNewItemLine(@RequestBody ItemLineRequestDTO itemLineRequestDTO) {
        itemLineServices.addItemLine(itemLineRequestDTO);
    }

    @DeleteMapping (path ="{id}")
    public void deleteItemLine(@PathVariable Long id){
        itemLineServices.deleteItemLine(id);
    }

    @PutMapping(path ="{id}")
    public void updateItemLine(@PathVariable Long id,
                               @RequestBody ItemLineRequestDTO itemLineRequestDTO){
        itemLineServices.updateItemLine(id,itemLineRequestDTO);
    }

    @PostMapping(path ="/addProductToLine")
    public void  addProductToLine(@RequestBody AddProductToLineDTO addProductToLineDTO) {
        itemLineServices.addProductToLine(addProductToLineDTO);
    }
}
