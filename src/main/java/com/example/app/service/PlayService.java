package com.example.app.service;

import com.example.app.dto.PlayDto;
import com.example.app.exception.play.NoPlayFoundException;
import com.example.app.mapper.PlayMapper;
import com.example.app.model.Play;
import com.example.app.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayService {

    @Autowired
    private PlayRepository playRepository;

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

    public PlayDto save(PlayDto playDto) {              //throws any error ???

        Play play = playMapper.dtoToModel(playDto);
        play = playRepository.save(play);

        ticketService.generateTickets(play);

        return playMapper.modelToDto(play);
    }
}
