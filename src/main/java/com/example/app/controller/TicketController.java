package com.example.app.controller;

import com.example.app.dto.TicketDto;
import com.example.app.exception.ticket.NoTicketFoundException;
import com.example.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAll() {

        try {
            return new ResponseEntity<>(ticketService.getAll(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoTicketFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
