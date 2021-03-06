package com.example.app.controller;

import com.example.app.dto.TheaterDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.theater.NoTheaterFoundException;
import com.example.app.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public ResponseEntity<List<TheaterDto>> getAll() {

        try {
            return new ResponseEntity<>(theaterService.getAll(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoTheaterFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<TheaterDto> save(@RequestBody TheaterDto theaterDto){

        try {
            return new ResponseEntity<>(theaterService.save(theaterDto), HttpStatus.OK);
        } catch (InvalidNameException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
