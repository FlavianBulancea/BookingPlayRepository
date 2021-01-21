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
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String email;

    private String fullName;

    private Long phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets;
}
