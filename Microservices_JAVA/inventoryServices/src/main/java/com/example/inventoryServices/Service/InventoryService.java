package com.example.inventoryServices.Service;

import com.example.inventoryServices.Repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public boolean inStock(String skuCode){
       return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }

}
