package com.example.demo6.controller;

import com.example.demo6.domain.CreateOrder;
import com.example.demo6.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping("api/v1/orders")
//    public Response<Void> newOrder(){
//        HashMap<Integer, Integer> orderMap= new HashMap<>();
//        orderMap.put(1,5);
//        orderMap.put(2,10);
//        orderService.newOrder(CreateOrder.builder()
//                .customerId(1)
//                .quantityByProduct(orderMap)
//                .build());
//        return Response.success(null);
//    }
        @PostMapping("api/v1/orders")
        public Response<Void> newOrder(
                //객체를 만들기 위해 newOrderRequest클래스를 만듦
                @RequestBody NewOrderRequest request
        ){
            orderService.newOrder(CreateOrder.builder()
                            .storeId(request.getStoreId())
                            .customerId(request.getCustomerId())
                            .quantityByProduct(request.getProducts())
                    .build());
            return Response.success(null);
    }
}
