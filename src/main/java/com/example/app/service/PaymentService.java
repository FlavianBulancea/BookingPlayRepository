package com.example.app.service;

import com.example.app.dto.PaymentDto;
import com.example.app.exception.payment.NoPaymentFoundException;
import com.example.app.mapper.PaymentMapper;
import com.example.app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public List<PaymentDto> getAll() throws NoPaymentFoundException {

        List<PaymentDto> paymentDtos = paymentRepository.findAll().stream()
                .map(payment -> paymentMapper.modelToDto(payment))
                .collect(Collectors.toList());

        if (paymentDtos.size() == 0)
            throw new NoPaymentFoundException();

        return paymentDtos;
    }
}
