package com.example.demo6.controller;

import com.example.demo6.domain.CreateCustomer;
import com.example.demo6.domain.Customer;
import com.example.demo6.domain.CustomerDto;
import com.example.demo6.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    //새로운 소비자를 만들기때문에 post가 적절
//    @PostMapping("api/v1/customers")
//    public Customer createNewCustomer(
//            @RequestParam String name,
//            @RequestParam String address,
//            @RequestParam String phoneNumber
//            )
//
//    {
//        return customerService.newCustomer(
//                CreateCustomer.builder()
//                        .address(address)
//                        .name(name)
//                        .phoneNumber(phoneNumber)
//                        .build()
//        );
//    }
    //Line 20~35 : 외부로 customer의 id까지 노출이 되기때문에,Dto활용 필요
//    @PostMapping("api/v1/customers")
//    public CustomerDto createNewCustomer(
//            @RequestParam String name,
//            @RequestParam String address,
//            @RequestParam String phoneNumber
//    )
//
//    {
//        return customerService.newCustomer(
//                CreateCustomer.builder()
//                        .address(address)
//                        .name(name)
//                        .phoneNumber(phoneNumber)
//                        .build()
//        );
//    }
    //데이터 반환이 성공적인지의 여부를 판단할 Response 클래스를 이용하여 코드 수정
    @PostMapping("api/v1/customers")
    public Response<CustomerDto> createNewCustomer(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    )

    {
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .build()
        ));
    }
    //들어온 데이터가 일정한 형태로 처리됨

}
