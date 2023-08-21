package com.example.orderServices.Service;


import com.example.orderServices.DTO.OrderRequest;
import com.example.orderServices.DTO.OrderItemsDTO;
import com.example.orderServices.Entity.InventoryResponse;
import com.example.orderServices.Entity.Order;
import com.example.orderServices.Entity.OrderItems;
import com.example.orderServices.Repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final WebClient webClient;
    public  void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrdernumber(UUID.randomUUID().toString());

        List<OrderItems> orderitemsList= orderRequest.getOrderItems()
                .stream().map(this::mapToDTO).toList();

        order.setOrderItemsList(orderitemsList);
        List<String> skuCodes=order.getOrderItemsList().stream().map(OrderItems::getSkuCode).toList();

        InventoryResponse[] result = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        assert result != null;
        boolean isInStock = Arrays.stream(result).allMatch(InventoryResponse::isInStock);

        if (isInStock){
            orderRepo.save(order);
        }else {
            throw new IllegalArgumentException("Product not Available in the Inventory");
        }

    }

    private OrderItems mapToDTO(OrderItemsDTO orderitemsDTO){
        return OrderItems.builder()
                .price(orderitemsDTO.getPrice())
                .quantity(orderitemsDTO.getQuantity())
                .skuCode(orderitemsDTO.getSkuCode())
                .build();
    }

}
