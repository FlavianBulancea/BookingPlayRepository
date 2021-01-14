package com.example.app.controller;

import com.example.app.dto.CustomerDto;
import com.example.app.exception.customer.NoCustomerFoundException;
import com.example.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {

        try {
            return new ResponseEntity<>(customerService.getAll(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoCustomerFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
