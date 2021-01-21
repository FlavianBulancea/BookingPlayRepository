package com.example.app.dto;

import lombok.Data;

@Data
public class PaymentInformationDto {

    private PaymentDto paymentDto;
    private CustomerDto customerDto;
    private TicketDto ticketDto;
}
