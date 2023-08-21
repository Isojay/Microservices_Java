package com.example.orderServices.Service;


import com.example.orderServices.DTO.OrderRequest;
import com.example.orderServices.DTO.OrderItemsDTO;
import com.example.orderServices.Entity.Order;
import com.example.orderServices.Entity.OrderItems;
import com.example.orderServices.Repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    public  void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrdernumber(UUID.randomUUID().toString());

        List<OrderItems> orderitemsList= orderRequest.getOrderItems()
                .stream().map(this::mapToDTO).toList();

        order.setOrderItemsList(orderitemsList);
        orderRepo.save(order);
    }

    private OrderItems mapToDTO(OrderItemsDTO orderitemsDTO){
        return OrderItems.builder()
                .price(orderitemsDTO.getPrice())
                .quantity(orderitemsDTO.getQuantity())
                .skuCode(orderitemsDTO.getSkuCode())
                .build();
    }

}
