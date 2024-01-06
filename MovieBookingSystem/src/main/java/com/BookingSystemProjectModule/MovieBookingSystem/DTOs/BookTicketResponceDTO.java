package com.BookingSystemProjectModule.MovieBookingSystem.DTOs;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponceDTO {

    private int ticketId;
    private String ticketStatus;
    private String message;
    private List<String> bookedSeats;
    private String movieName;
    private String theatreName;
    private String AuditoriumName;
}
