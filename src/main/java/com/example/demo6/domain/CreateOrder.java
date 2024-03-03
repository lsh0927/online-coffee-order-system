package com.example.demo6.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private Map<Integer, Integer> quantityByProduct;

}
