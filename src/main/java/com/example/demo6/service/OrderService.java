package com.example.demo6.service;

import com.example.demo6.domain.CreateOrder;
import com.example.demo6.domain.Order;
import com.example.demo6.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //이 과정 복습
    public void newOrder(CreateOrder createOrder){
        Order entity= Order.newOrder(createOrder);
        orderRepository.save(entity);
        //Order라는 객체의 mappedcollection부분도
    }
}
