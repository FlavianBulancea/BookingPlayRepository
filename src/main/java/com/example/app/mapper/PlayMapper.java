package com.example.app.mapper;

import com.example.app.dto.PlayDto;
import com.example.app.model.Play;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlayMapper {

    @Mappings({@Mapping(source = "theaterId", target = "theater.id")})
    Play dtoToModel(PlayDto dto);

    @Mappings({@Mapping(source = "theater.id", target = "theaterId")})
    PlayDto modelToDto(Play play);
}
