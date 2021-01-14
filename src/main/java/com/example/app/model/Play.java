package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private String name;

    private Timestamp start;

    private Timestamp end;

    @OneToMany(mappedBy = "play")
    private List<Ticket> tickets;

}
