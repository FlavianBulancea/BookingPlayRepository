package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private Long id;
    private Long customerId;
    private Long theaterId;
    private Long playId;
    private Long seat_number;
    private Float price;
}
