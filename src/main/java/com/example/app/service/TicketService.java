package com.example.app.service;

import com.example.app.dto.TicketDto;
import com.example.app.exception.ticket.NoTicketFoundException;
import com.example.app.mapper.TicketMapper;
import com.example.app.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    public List<TicketDto> getAll() throws NoTicketFoundException {

        List<TicketDto> ticketDtos = ticketRepository.findAll().stream()
                .map(ticket -> ticketMapper.modelToDto(ticket))
                .collect(Collectors.toList());

        if (ticketDtos.size() == 0)
            throw new NoTicketFoundException();

        return ticketDtos;
    }
}
