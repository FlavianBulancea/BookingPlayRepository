package com.example.app.exception;

public class InvalidNameException extends BookingPlayException {

    public static final String MESSAGE = "The name is not valid.";

    public InvalidNameException() {
        super(MESSAGE);
    }
}