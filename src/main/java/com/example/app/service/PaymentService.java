package com.example.app.service;

import com.example.app.dto.*;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.customer.InvalidEmailException;
import com.example.app.exception.customer.InvalidPhoneNumberException;
import com.example.app.exception.payment.NoPaymentFoundException;
import com.example.app.mapper.PaymentMapper;
import com.example.app.model.Payment;
import com.example.app.model.Play;
import com.example.app.repository.PaymentRepository;
import com.example.app.util.EmailValidation;
import com.example.app.util.PhoneNumberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TicketService ticketService;

    public List<PaymentDto> getAll() throws NoPaymentFoundException {

        List<PaymentDto> paymentDtos = paymentRepository.findAll().stream()
                .map(payment -> paymentMapper.modelToDto(payment))
                .collect(Collectors.toList());

        if (paymentDtos.size() == 0)
            throw new NoPaymentFoundException();

        return paymentDtos;
    }

    public PaymentDto save(PaymentInformationDto paymentInformationDto) throws InvalidPhoneNumberException, InvalidEmailException, InvalidNameException{

        CustomerDto customerDto = paymentInformationDto.getCustomerDto();
        Long ticketId = paymentInformationDto.getTicketId();
        Timestamp dateTime = paymentInformationDto.getDateTime();

        customerDto = customerService.saveOrUpdate(customerDto);

        TicketDto ticketDto = ticketService.update(ticketId, customerDto.getId());

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCustomerId(customerDto.getId());
        paymentDto.setTicketId(ticketDto.getId());
        paymentDto.setAmount(ticketDto.getPrice());
        paymentDto.setDateTime(dateTime);

        Payment payment = paymentMapper.dtoToModel(paymentDto);
        paymentRepository.save(payment);

        return paymentMapper.modelToDto(payment);
    }
}
