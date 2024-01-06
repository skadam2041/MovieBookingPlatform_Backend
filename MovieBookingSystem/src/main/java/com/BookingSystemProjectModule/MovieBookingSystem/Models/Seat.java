package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seat")
public class Seat extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private SeatType  seatType;
    private int seatNumber;
    private int seatRow;
    private int seatColumn;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Auditorium auditorium;
}
