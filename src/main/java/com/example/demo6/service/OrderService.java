package com.example.demo6.service;

import com.example.demo6.domain.CreateOrder;
import com.example.demo6.domain.Order;
import com.example.demo6.domain.StoreProduct;
import com.example.demo6.repository.OrderRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository, StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }


    //이 과정 복습
    //Line 28~ 재고 수량 고려

    public void newOrder(CreateOrder createOrder){

        List<StoreProduct> storeProducts= new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry :createOrder.getQuantityByProduct().entrySet()) {
            // 주문 목록에서 id와 개수 가져옴
            Integer productId= entry.getKey();
            Integer buyQuantity= entry.getValue();

            StoreProduct storeProduct= storeService.getStoreProduct(
                    createOrder.getStoreId(),productId);

            //상품 목록의 재고 가져옴
            int stockQuantity = storeProduct.getStockQuantity();


            if (buyQuantity>stockQuantity){
                throw new RuntimeException("재고가 부족합니다");
            }
            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);

        }

        Order entity= Order.newOrder(createOrder);
        orderRepository.save(entity);
        //Order라는 객체의 mappedcollection부분도
        
        storeService.saveAll(storeProducts);
        //기존에는 저장만했는데, 재고상황을 앞뒤로 고려함
    }
}
