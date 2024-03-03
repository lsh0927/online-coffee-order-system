package com.example.demo6.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter@Table(name = "order_item")
public class OrderItem {

    @Id
    private int orderItemId;

    @Column
    private int productId;

    @Column
    private int orderId;

    @Column
    private int orderQuantity;

    public OrderItem(int productId, int orderQuantity) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }
}
