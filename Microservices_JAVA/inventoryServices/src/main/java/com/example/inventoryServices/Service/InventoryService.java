package com.example.inventoryServices.Service;

import com.example.inventoryServices.Entity.InventoryResponse;
import com.example.inventoryServices.Repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public List<InventoryResponse> inStock(List<String > skuCode){
       return inventoryRepo.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .inStock(inventory.getQuantity()>0)
                            .build()
        ).toList();
    }



}
