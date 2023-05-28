package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/v1/customer")
    public ResponseEntity<ResponseWrapper> getCustomerList() {
        return ResponseEntity.ok().body(new ResponseWrapper("Customers are successfully retrieved", customerService.retrieveCustomers(), HttpStatus.ACCEPTED));
    }

}
