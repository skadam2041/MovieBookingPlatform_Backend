package com.BookingSystemProjectModule.MovieBookingSystem.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "show_seat_type")
public class ShowSeatType extends BaseModel{
    @ManyToOne(cascade = CascadeType.ALL)
    private Show currentShow;
    @ManyToOne(cascade = CascadeType.ALL)
    private SeatType seatType;
    private int price;

}
