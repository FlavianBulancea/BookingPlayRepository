package com.example.app.exception.payment;

import com.example.app.exception.BookingPlayException;

public class NoPaymentFoundException extends BookingPlayException {

    public static final String MESSAGE = "No payment found.";

    public NoPaymentFoundException() {
        super(MESSAGE);
    }
}