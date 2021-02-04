package com.example.app.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class PaymentInformationDto {

    private CustomerDto customerDto;
    private List<Long> ticketIds;
    private Timestamp dateTime;
}
