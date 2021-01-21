package com.example.app.exception.ticket;

import com.example.app.exception.BookingPlayException;

public class InvalidTicketException  extends BookingPlayException {

    public static final String MESSAGE = "Invalid ticket. Check ticket for missing information.";

    public InvalidTicketException() {
        super(MESSAGE);
    }
}