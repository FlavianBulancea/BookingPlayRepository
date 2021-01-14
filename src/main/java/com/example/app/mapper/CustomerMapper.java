package com.example.app.mapper;

import com.example.app.dto.CustomerDto;
import com.example.app.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer dtoToModel(CustomerDto dto);

    CustomerDto modelToDto(Customer customer);
}
