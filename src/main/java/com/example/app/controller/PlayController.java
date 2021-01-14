package com.example.app.controller;

import com.example.app.dto.PlayDto;
import com.example.app.exception.play.NoPlayFoundException;
import com.example.app.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
