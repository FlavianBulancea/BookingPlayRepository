package com.example.app.exception;

public class BookingPlayException extends Exception{

    private static final String MESSAGE = "Unknown error occurred !";

    public BookingPlayException() {
        super(MESSAGE);
    }

    public BookingPlayException(String message) {
        super(message);
    }
}