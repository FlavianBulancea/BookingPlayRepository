package com.example.app.mapper;

import com.example.app.dto.TicketDto;
import com.example.app.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mappings({@Mapping(source = "customerId", target = "customer.id"),
            @Mapping(source = "theaterId", target = "theater.id"),
            @Mapping(source = "playId", target = "play.id")})
    Ticket dtoToModel(TicketDto dto);

    @Mappings({@Mapping(source = "customer.id", target = "customerId"),
            @Mapping(source = "theater.id", target = "theaterId"),
            @Mapping(source = "play.id", target = "playId")})
    TicketDto modelToDto(Ticket category);
}
