package com.example.inventoryServices.Controller;


import com.example.inventoryServices.Entity.Inventory;
import com.example.inventoryServices.Repository.InventoryRepo;
import com.example.inventoryServices.Service.InventoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    private final InventoryRepo inventoryRepo;

    @PostConstruct
    public void LoadData(){
        Inventory inventory = new Inventory();

        inventory.setSkuCode("Iphone 13 red");
        inventory.setQuantity(100);
        inventoryRepo.save(inventory);

    }

    @GetMapping
    private boolean inStock(@PathVariable("sku-code") String skuCode){

        return inventoryService.inStock(skuCode);
    }


}
