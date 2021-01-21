package com.example.app.service;

import com.example.app.dto.PlayDto;
import com.example.app.dto.TheaterDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.theater.NoTheaterFoundException;
import com.example.app.mapper.TheaterMapper;
import com.example.app.model.Play;
import com.example.app.model.Theater;
import com.example.app.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterMapper theaterMapper;

    public List<TheaterDto> getAll() throws NoTheaterFoundException {

        List<TheaterDto> theaterDtos = theaterRepository.findAll().stream()
                .map(theater -> theaterMapper.modelToDto(theater))
                .collect(Collectors.toList());

        if (theaterDtos.size() == 0)
            throw new NoTheaterFoundException();

        return theaterDtos;
    }

    public TheaterDto save(TheaterDto theaterDto) throws InvalidNameException {

        if(theaterDto.getName().length() == 0)
            throw new InvalidNameException();

        Theater theater = theaterMapper.dtoToModel(theaterDto);
        theater = theaterRepository.save(theater);

        return theaterMapper.modelToDto(theater);
    }
}
