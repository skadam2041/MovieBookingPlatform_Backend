package com.BookingSystemProjectModule.MovieBookingSystem.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private long showId;
    List<Long> seatIds;
    private long userId;


}
