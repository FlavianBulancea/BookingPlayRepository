package com.example.app.controller;

import com.example.app.dto.CustomerDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.customer.InvalidEmailException;
import com.example.app.exception.customer.NoCustomerFoundException;
import com.example.app.exception.customer.InvalidPhoneNumberException;
import com.example.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {

        try {
            return new ResponseEntity<>(customerService.saveOrUpdate(customerDto), HttpStatus.OK);
        } catch (InvalidNameException | InvalidEmailException | InvalidPhoneNumberException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
