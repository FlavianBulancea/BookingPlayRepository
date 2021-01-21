package com.example.app.controller;

import com.example.app.dto.PaymentDto;
import com.example.app.dto.PaymentInformationDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.customer.InvalidEmailException;
import com.example.app.exception.customer.InvalidPhoneNumberException;
import com.example.app.exception.payment.NoPaymentFoundException;
import com.example.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAll() {

        try {
            return new ResponseEntity<>(paymentService.getAll(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoPaymentFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    public ResponseEntity<PaymentDto> save(@RequestBody PaymentInformationDto paymentInformationDto) {

        try {
            return new ResponseEntity<>(paymentService.save(paymentInformationDto), HttpStatus.OK);
        } catch (InvalidPhoneNumberException | InvalidNameException | InvalidEmailException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
