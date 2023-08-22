package com.example.inventoryServices.Controller;


import com.example.inventoryServices.Entity.Inventory;
import com.example.inventoryServices.Entity.InventoryResponse;
import com.example.inventoryServices.Repository.InventoryRepo;
import com.example.inventoryServices.Service.InventoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    private List<InventoryResponse> inStock(@RequestParam List<String> skuCode){
        return inventoryService.inStock(skuCode);
    }


}
