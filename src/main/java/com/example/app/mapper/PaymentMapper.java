package com.example.app.mapper;

import com.example.app.dto.PaymentDto;
import com.example.app.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mappings({@Mapping(source = "customerId", target = "customer.id"),
            @Mapping(source = "ticketId", target = "ticket.id")})
    Payment dtoToModel(PaymentDto dto);

    @Mappings({@Mapping(source = "customer.id", target = "customerId"),
            @Mapping(source = "ticket.id", target = "ticketId")})
    PaymentDto modelToDto(Payment payment);
}
