package com.example.app.controller;

import com.example.app.dto.PlayDto;
import com.example.app.exception.InvalidNameException;
import com.example.app.exception.play.NoPlayFoundException;
import com.example.app.exception.theater.NoTheaterFoundException;
import com.example.app.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/play")
public class PlayController {

    @Autowired
    private PlayService playService;

    @GetMapping
    public ResponseEntity<List<PlayDto>> getAllSorted() {

        try {
            return new ResponseEntity<>(playService.getAllSorted(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoPlayFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    public ResponseEntity<PlayDto> save(@RequestBody PlayDto playDto){

        try {
            return new ResponseEntity<>(playService.save(playDto), HttpStatus.OK);
        } catch (InvalidNameException | NoTheaterFoundException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<PlayDto> update(@RequestBody PlayDto playDto){

        try {
            return new ResponseEntity<>(playService.update(playDto), HttpStatus.OK);
        } catch (InvalidNameException | NoPlayFoundException | NoTheaterFoundException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public ResponseEntity<PlayDto> delete(@RequestBody Long id){

        try {
            playService.delete(id);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (NoPlayFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
