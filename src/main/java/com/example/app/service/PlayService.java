package com.example.app.service;

import com.example.app.dto.PlayDto;
import com.example.app.dto.TicketDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.play.NoPlayFoundException;
import com.example.app.exception.theater.NoTheaterFoundException;
import com.example.app.mapper.PlayMapper;
import com.example.app.model.Play;
import com.example.app.repository.PlayRepository;
import com.example.app.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayService {

    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private PlayMapper playMapper;

    @Autowired
    private TicketService ticketService;

    public List<PlayDto> getAll() throws NoPlayFoundException {

        List<PlayDto> playDtos = playRepository.findAll().stream()
                .map(play -> playMapper.modelToDto(play))
                .collect(Collectors.toList());

        if (playDtos.size() == 0)
            throw new NoPlayFoundException();

        return playDtos;
    }

    public List<PlayDto> getAllSorted() throws NoPlayFoundException {

        List<PlayDto> playDtos = playRepository.findByOrderByStartAsc().stream()
                .map(play -> playMapper.modelToDto(play))
                .collect(Collectors.toList());

        if (playDtos.size() == 0)
            throw new NoPlayFoundException();

        return playDtos;
    }

    public PlayDto save(PlayDto playDto) throws InvalidNameException, NoTheaterFoundException {

        if(playDto.getName().length() == 0)
            throw new InvalidNameException();

        if(!theaterRepository.existsById(playDto.getTheaterId()))
            throw new NoTheaterFoundException();

        Play play = playMapper.dtoToModel(playDto);
        play = playRepository.save(play);

        List<TicketDto> ticketDtos = ticketService.generateTickets(play);
        ticketService.saveTickets(ticketDtos);

        return playMapper.modelToDto(play);
    }

    public PlayDto update(PlayDto playDto) throws NoPlayFoundException, InvalidNameException, NoTheaterFoundException{

        if (playDto.getName().length() == 0)
            throw new InvalidNameException();

        if(!playRepository.existsById(playDto.getId()))
            throw new NoPlayFoundException();

        if(!theaterRepository.existsById(playDto.getTheaterId()))
            throw new NoTheaterFoundException();

        Play play = playMapper.dtoToModel(playDto);
        play = playRepository.save(play);
        return playMapper.modelToDto(play);
    }

    public void delete(Long id) throws NoPlayFoundException {

        if(playRepository.existsById(id))
            playRepository.deleteById(id);
        else
            throw new NoPlayFoundException();
    }
}
