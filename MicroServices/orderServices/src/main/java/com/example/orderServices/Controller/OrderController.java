package com.example.orderServices.Controller;

import com.example.orderServices.DTO.OrderRequest;
import com.example.orderServices.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String orderPlaced(@RequestBody OrderRequest orderRequest){

        orderService.placeOrder(orderRequest);

        return "order Placed";
    }





}
