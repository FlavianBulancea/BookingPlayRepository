package com.example.app.service;

import com.example.app.dto.TicketDto;
import com.example.app.exception.ticket.InvalidTicketException;
import com.example.app.exception.ticket.NoTicketFoundException;
import com.example.app.mapper.TicketMapper;
import com.example.app.model.Customer;
import com.example.app.model.Play;
import com.example.app.model.Theater;
import com.example.app.model.Ticket;
import com.example.app.repository.CustomerRepository;
import com.example.app.repository.TheaterRepository;
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

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<TicketDto> getAll() throws NoTicketFoundException {

        List<TicketDto> ticketDtos = ticketRepository.findAll().stream()
                .map(ticket -> ticketMapper.modelToDto(ticket))
                .collect(Collectors.toList());

        if (ticketDtos.size() == 0)
            throw new NoTicketFoundException();

        return ticketDtos;
    }

    public List<TicketDto> generateTickets(Play play) {

        List<TicketDto> ticketDtos = new ArrayList<>();

        Long playId = play.getId();
        Long theaterId = play.getTheater().getId();

        Theater theater = theaterRepository.getOne(theaterId);

        Long numberOfSeats = theater.getNumberOfSeats();

        for (int i = 0; i < numberOfSeats; i++) {
            TicketDto ticketDto = new TicketDto();
            ticketDtos.add(ticketDto);

            ticketDtos.get(i).setTheaterId(theaterId);
            ticketDtos.get(i).setPlayId(playId);
            ticketDtos.get(i).setSeatNumber((long) i + 1);
            ticketDtos.get(i).setPrice((float) 14.99);
        }
        for (int i = 0; i < numberOfSeats / 4; i++) {
            ticketDtos.get(i).setPrice((float) 24.99);
        }

        return ticketDtos;
    }

    public void saveTickets(List<TicketDto> ticketDtos) throws InvalidTicketException{

        for (TicketDto ticketDto : ticketDtos) {
            save(ticketDto);
        }
    }

    public TicketDto save(TicketDto ticketDto) throws InvalidTicketException {

        Ticket ticket = ticketMapper.dtoToModel(ticketDto);

        if (ticketDto.getCustomerId() == null)
            ticket.setCustomer(null);

        if (ticketDto.getPlayId() == null || ticketDto.getTheaterId() == null
                || ticketDto.getPrice() == null || ticketDto.getSeatNumber() == null)
            throw new InvalidTicketException();

        ticket = ticketRepository.save(ticket);

        return ticketMapper.modelToDto(ticket);
    }

    public TicketDto update(Long ticketId, Long customerId) {

        Customer customer = customerRepository.getOne(customerId);
        Ticket ticket = ticketRepository.getOne(ticketId);

        ticket.setCustomer(customer);

        ticketRepository.save(ticket);

        return ticketMapper.modelToDto(ticket);
    }
}
