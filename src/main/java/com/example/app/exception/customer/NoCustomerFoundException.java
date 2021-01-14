package com.example.app.exception.customer;

import com.example.app.exception.BookingPlayException;

public class NoCustomerFoundException extends BookingPlayException {

    public static final String MESSAGE = "No customer found.";

    public NoCustomerFoundException() {
        super(MESSAGE);
    }
}