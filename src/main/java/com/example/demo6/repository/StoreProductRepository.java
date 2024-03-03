package com.example.demo6.repository;

import com.example.demo6.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreProductRepository extends CrudRepository<StoreProduct,Integer> {
    //특정 조건에 따라 데이터를 가져와야 함
    Optional<StoreProduct> findByStoreIdAndProductId(int store, int productId);
}
