package com.example.app.exception.ticket;

import com.example.app.exception.BookingPlayException;

public class NoTicketFoundException extends BookingPlayException {

    public static final String MESSAGE = "No ticket found.";

    public NoTicketFoundException() {
        super(MESSAGE);
    }
}