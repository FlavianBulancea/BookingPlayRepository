package com.example.app.exception.play;

import com.example.app.exception.BookingPlayException;

public class NoPlayFoundException extends BookingPlayException {

    public static final String MESSAGE = "No play found.";

    public NoPlayFoundException() {
        super(MESSAGE);
    }
}