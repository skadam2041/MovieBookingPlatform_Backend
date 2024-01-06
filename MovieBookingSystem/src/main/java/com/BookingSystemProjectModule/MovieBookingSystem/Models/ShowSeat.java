package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "showSeat")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show currentShow;
    @ManyToOne
    private Seat currentSeat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date  bookedAt;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  Ticket ticket;


}
