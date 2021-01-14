package com.example.app.mapper;

import com.example.app.dto.TheaterDto;
import com.example.app.model.Theater;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

    Theater dtoToModel(TheaterDto dto);

    TheaterDto modelToDto(Theater theater);
}
