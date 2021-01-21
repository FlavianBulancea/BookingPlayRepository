package com.example.app.exception.customer;

import com.example.app.exception.BookingPlayException;

public class InvalidEmailException extends BookingPlayException {

    public static final String MESSAGE = "The email is not valid.";

    public InvalidEmailException() {
        super(MESSAGE);
    }
}
