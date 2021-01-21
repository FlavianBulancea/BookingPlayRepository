package com.example.app.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaymentInformationDto {

    private CustomerDto customerDto;
    private Long ticketId;
    private Timestamp dateTime;
}
