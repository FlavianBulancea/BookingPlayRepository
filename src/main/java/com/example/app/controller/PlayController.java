package com.example.app.controller;

import com.example.app.dto.PlayDto;
import com.example.app.exception.play.NoPlayFoundException;
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
    public ResponseEntity<List<PlayDto>> getAll() {

        try {
            return new ResponseEntity<>(playService.getAll(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoPlayFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/sorted")
    public ResponseEntity<List<PlayDto>> getAllSorted() {

        try {
            return new ResponseEntity<>(playService.getAllSorted(), new HttpHeaders(), HttpStatus.OK);
        } catch (NoPlayFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping
    public ResponseEntity<PlayDto> save(@RequestBody PlayDto playDto){

        return new ResponseEntity<>(playService.save(playDto), HttpStatus.OK);
    }
}
