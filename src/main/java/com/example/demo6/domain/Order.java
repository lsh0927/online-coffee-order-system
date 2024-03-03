package com.example.demo6.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderedAt;


    //내부적으로 orderId와 orderItems는 연결되어있음을 알려줌

    @MappedCollection(idColumn = "orderItem_id", keyColumn = "order_id")
    private List<OrderItem> orderItems= new ArrayList<>();


    public Order(int orderId, List<OrderItem> orderItems) {
        this.orderedAt=Timestamp.valueOf(LocalDateTime.now());
        this.orderId = orderId;
        this.orderItems = orderItems;
    }


    public static  Order newOrder(CreateOrder createOrder){
        List<OrderItem> items= new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry: createOrder.getQuantityByProduct().entrySet()){
            items.add(new OrderItem(entry.getKey(),entry.getValue()));
        }

        return new Order(createOrder.getCustomerId(), items);
    }
}
