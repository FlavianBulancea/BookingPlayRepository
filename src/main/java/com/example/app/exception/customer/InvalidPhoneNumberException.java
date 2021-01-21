package com.example.app.exception.customer;

import com.example.app.exception.BookingPlayException;

public class InvalidPhoneNumberException extends BookingPlayException {

    public static final String MESSAGE = "Your phone number must be 9 digits long.";

    public InvalidPhoneNumberException() {
        super(MESSAGE);
    }
}