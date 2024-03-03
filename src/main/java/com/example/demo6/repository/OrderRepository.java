package com.example.demo6.repository;

import com.example.demo6.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends CrudRepository<Order,Integer> {
}
