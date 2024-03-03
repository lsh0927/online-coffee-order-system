package com.example.demo6.service;

import com.example.demo6.domain.CreateCustomer;
import com.example.demo6.domain.Customer;
import com.example.demo6.domain.CustomerDto;
import com.example.demo6.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //새로운 Customer를 만들기 위한 어노테이션
//    @Transactional
//    public Customer newCustomer(CreateCustomer customer){
//        Customer entity=Customer.newCustomer(customer);
//        return customerRepository.save(entity);
//    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer){
        Customer entity=Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);
        return CustomerDto.builder()
                .name(saved.getName())
                .address(saved.getAddress())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
