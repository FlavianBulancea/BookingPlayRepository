package com.example.app.exception.theater;

import com.example.app.exception.BookingPlayException;

public class NoTheaterFoundException extends BookingPlayException {

    public static final String MESSAGE = "No theater found.";

    public NoTheaterFoundException() {
        super(MESSAGE);
    }
}