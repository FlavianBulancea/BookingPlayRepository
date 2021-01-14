package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long numberOfSeats;

    @OneToMany(mappedBy = "theater")
    private List<Play> plays;

    @OneToMany(mappedBy = "theater")
    private List<Ticket> tickets;
}
