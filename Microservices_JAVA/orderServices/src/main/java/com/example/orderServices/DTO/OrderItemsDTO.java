package com.example.orderServices.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {

    private long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

}
