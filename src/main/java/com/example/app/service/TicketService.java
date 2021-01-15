package com.example.app.service;

import com.example.app.dto.TicketDto;
import com.example.app.exception.ticket.NoTicketFoundException;
import com.example.app.mapper.TicketMapper;
import com.example.app.model.Play;
import com.example.app.model.Ticket;
import com.example.app.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void generateTickets(Play play) {

        List<TicketDto> ticketDtos = new ArrayList<>();
        Long theaterId = play.getTheater().getId();
        Long playId = play.getId();
        Long numberOfSeats = play.getTheater().getNumberOfSeats();


        for (int i = 0; i < numberOfSeats; i++) {
            TicketDto ticketDto = new TicketDto();
            ticketDtos.add(ticketDto);

            ticketDtos.get(i).setTheaterId(theaterId);
            ticketDtos.get(i).setPlayId(playId);
            ticketDtos.get(i).setSeatNumber((long) i);
            ticketDtos.get(i).setPrice((float) 14.99);
        }
        for (int i = 0; i < numberOfSeats / 4; i++) {
            ticketDtos.get(i).setPrice((float) 24.99);
        }

        saveTickets(ticketDtos);
    }

    private void saveTickets(List<TicketDto> ticketDtos) {

        List<Ticket> tickets = ticketDtos.stream()
                .map(ticketDto -> ticketMapper.dtoToModel(ticketDto))
                .collect(Collectors.toList());

        for (Ticket ticket : tickets) {
            ticketRepository.save(ticket);
        }
    }
}
