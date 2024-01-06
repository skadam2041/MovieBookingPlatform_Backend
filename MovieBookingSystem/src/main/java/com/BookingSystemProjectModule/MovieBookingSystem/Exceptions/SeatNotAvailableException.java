package com.BookingSystemProjectModule.MovieBookingSystem.Exceptions;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(String message) {
        super(message);
    }
}
