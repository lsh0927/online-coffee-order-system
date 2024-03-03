package com.example.demo6.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Table(name = "customers")
public class Customer {

    @Id
    private int customerId;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;


    // 생성자에 ID를 넣지 않는 이유는 어노테이션이 알아서 값을 생성해주기 때문

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

//    public static Customer newCustomer(String name, String address, String phoneNumber)
//    {
//        return newCustomer(name, address, phoneNumber);
//    }

    //더 편하게 하는 방법
    public static Customer newCustomer(CreateCustomer customer)
    {
        return new Customer(customer.getName(), customer.getAddress(),customer.getPhoneNumber());
    }
}
