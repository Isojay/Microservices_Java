package com.example.inventoryServices.Controller;


import com.example.inventoryServices.Entity.Inventory;
import com.example.inventoryServices.Entity.InventoryResponse;
import com.example.inventoryServices.Entity.Request;
import com.example.inventoryServices.Repository.InventoryRepo;
import com.example.inventoryServices.Service.InventoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    private List<InventoryResponse> inStock(Request skuCode){
//
//        List<String> getcode = skuCode;
//        for (int i = 0; i < getcode.size(); i++) {
//            System.out.println(getcode.get(i)); // Print each SKU code
//        }

        return inventoryService.inStock(Collections.singletonList(skuCode.getSkuCode()));
    }
//    @GetMapping("/text")
//    public  String hello(){
//        return "Hello this is form Inventory";
//    }


}
