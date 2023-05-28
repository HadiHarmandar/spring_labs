package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/api/v1/address")
    public ResponseEntity<ResponseWrapper> getAddressList() {
        return ResponseEntity.ok().body(new ResponseWrapper(true, "Address are successfully retrieved", 202, addressService.listAllAddress()));
    }

    @PostMapping("/api/v1/address")
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO address) {
        return ResponseEntity.ok().body(new ResponseWrapper(true, "Address created", 201, addressService.createAddress(address)));
    }

}
