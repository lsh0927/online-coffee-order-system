package com.example.demo6.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;

    //재고 개수와의 비교 확인을 위해 추가
    private int storeId;


    private Map<Integer, Integer> quantityByProduct;

}
